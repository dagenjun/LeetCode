package xc.proxy;

/**
 * @description:
 * @author: YCKJ2932
 * @create: 2021-01-07
 **/
public class SubjectImpl implements Subject {

    /**
     * @return: void
     * @description:
     * @author: YCKJ2932
     * @date: 2021/1/7 10:25
     */
    @Override
    public void register(String tag) {
        System.out.println("SubjectImpl注册成功" + tag);
    }
}
