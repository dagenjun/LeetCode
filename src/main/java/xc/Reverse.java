package xc;

/**
 * @description:
 * @author: YCKJ2932
 * @create: 2021-03-08
 **/
public class Reverse {
    public static void main(String[] args) {
        String str = "abcdefg";
        char[] chars = str.toCharArray();
        int low = 0;
        int top = chars.length - 1;
        while (low < top) {
            chars[top] ^= chars[low];
            chars[low] ^= chars[top];
            chars[top] ^= chars[low];
            low++;
            top--;
        }
        System.out.println(new String(chars));
    }
}
