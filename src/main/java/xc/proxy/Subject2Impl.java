package xc.proxy;

/**
 * @description:
 **/
public class Subject2Impl implements Subject {

    @Override
    public void register(String tag) {
        System.out.println("SubjectImpl222222注册成功" + tag);
    }
}
