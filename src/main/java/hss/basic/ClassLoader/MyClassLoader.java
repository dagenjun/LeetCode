package hss.basic.ClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author HSS
 * @Date: 2021/4/28 16:17
 * @Description:
 */
public class MyClassLoader {
    public static void main(String[] args) {
//        System.out.println(ClassLoader.getSystemClassLoader());
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(ClassLoader.getSystemClassLoader());
//            }
//        }, "a").start();

        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        MineClassLoader mineClassLoader = new MineClassLoader();
        try {
            Class<?> aClass = Class.forName("hss.basic.ClassLoader.person", true, mineClassLoader);
            try {
                Object o = aClass.newInstance();
                Field[] declaredFields = aClass.getDeclaredFields();
                for (int i = 0; i < declaredFields.length; i++) {
                    Field f = declaredFields[i];
                    f.setAccessible(true);
                    System.out.println(f);
                    if (f.getName().toString() == "name") {
                        f.set(o, "hss");
                    } else {
                        f.set(o, "man");
                    }
                }
                System.out.println(o);
                System.out.println(o.getClass().getClassLoader());

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}

class MineClassLoader extends ClassLoader {
    public MineClassLoader() {

    }

    public MineClassLoader(ClassLoader parent) {
        super(parent);
    }

    //重写子类加载器加载规则
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = getClassFile(name);
        try {
            byte[] bytes = getClassBytes(file);
            Class<?> c = this.defineClass(name, bytes, 0, bytes.length);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }

    private File getClassFile(String name) {
        File file = new File("D:/person.class");
        return file;
    }

    private byte[] getClassBytes(File file) throws Exception {
        // 这里要读入.class的字节，因此要使用字节流
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel wbc = Channels.newChannel(baos);
        ByteBuffer by = ByteBuffer.allocate(1024);

        while (true) {
            int i = fc.read(by);
            if (i == 0 || i == -1) {
                break;
            }
            by.flip();
            wbc.write(by);
            by.clear();
        }

        fis.close();

        return baos.toByteArray();
    }
}

