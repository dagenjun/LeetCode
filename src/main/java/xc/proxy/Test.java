package xc.proxy;

/**
 * @description:
 * @author: YCKJ2932
 * @create: 2021-01-07
 **/
public class Test {
    public static void main(String[] args) {
        Subject staticProxy = new StaticProxy();
        staticProxy.register("main");

        DynamicProxy dynamicProxy = new DynamicProxy();
        Subject subject = (Subject) dynamicProxy.bind(new SubjectImpl());
        subject.register("main");
    }
}
