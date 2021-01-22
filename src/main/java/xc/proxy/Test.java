package xc.proxy;

/**
 * @description: 代理模式验证类
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
