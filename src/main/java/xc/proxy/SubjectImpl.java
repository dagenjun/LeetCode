package xc.proxy;

/**
 * @description:
 **/
public class SubjectImpl implements Subject {

    @Override
    public void register(String tag) {
        System.out.println("SubjectImpl1111111注册成功" + tag);
    }
}
