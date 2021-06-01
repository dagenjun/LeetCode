package hss.test;

/**
 * @author HSS
 * @Date: 2021/5/31 14:16
 * @Description:
 */
public class TestString {
    public static void main(String[] args) {
        Integer a=2;
        String s1=Integer.toString(a);
        String s2=a.toString();
        String s3=String.valueOf(a);
        System.out.println(s1+s2+s3);

    }
}
