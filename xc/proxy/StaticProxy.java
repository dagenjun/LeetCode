package proxy;

/**
 * @description: 静态代理模式
 * @author: YCKJ2932
 * @create: 2021-01-07
 **/
public class StaticProxy implements Subject{
    private SubjectImpl subject;

    public StaticProxy() {
        this.subject = new SubjectImpl();
    }

    @Override
    public void register(String tag) {
        System.out.println("StaticProxy开始注册");
        subject.register(tag);
        System.out.println("StaticProxy完成注册");
    }
}
