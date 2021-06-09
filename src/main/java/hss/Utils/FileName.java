package hss.Utils;

/**
 * @author HSS
 * @Date: 2021/6/2 14:29
 * @Description:
 */
import java.io.*;
import java.util.*;

public class FileName {
    // 设置一个全局动态数组，来存放文件路径
    // 主要遍历文件夹，包含所有子文件夹、文件的情况时，用到递归，所以要这样设置
    public static ArrayList<String> dirAllStrArr = new ArrayList<String>();

    // 这里是仅仅查询当前路径下的所有文件夹、文件并且存放其路径到文件数组
    // 由于遇到文件夹不查询其包含所有子文件夹、文件，因此没必要用到递归
    public static ArrayList<String> Dir(File dirFile) throws Exception {
        ArrayList<String> dirStrArr = new ArrayList<String>();

        if (dirFile.exists()) {
            // 直接取出利用listFiles()把当前路径下的所有文件夹、文件存放到一个文件数组
            File files[] = dirFile.listFiles();
            for (File file : files) {
                // 如果传递过来的参数dirFile是以文件分隔符，也就是/或者\结尾，则如此构造
                if (dirFile.getPath().endsWith(File.separator)) {
                    dirStrArr.add(dirFile.getPath() + file.getName());
                } else {
                    // 否则，如果没有文件分隔符，则补上一个文件分隔符，再加上文件名，才是路径
                    dirStrArr.add(dirFile.getPath() + File.separator
                            + file.getName());
                }
            }
        }
        return dirStrArr;
    }

    public static void DirAll(File dirFile) throws Exception {

        if (dirFile.exists()) {
            File files[] = dirFile.listFiles();
            for (File file : files) {
                // 如果遇到文件夹则递归调用。
                if (file.isDirectory()) {
                    // 递归调用
                    DirAll(file);
                } else {
                    // 如果遇到文件夹则放入数组
                    if (dirFile.getPath().endsWith(File.separator)) {
                        dirAllStrArr.add(dirFile.getPath() + file.getName());
                    } else {
                        dirAllStrArr.add(dirFile.getPath() + File.separator
                                + file.getName());
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        File dirFile = new File("C:\\Users\\YCKJ3552\\Downloads");
        System.out.println(Dir(dirFile));
        DirAll(dirFile);
        System.out.println(dirAllStrArr);
    }
}