package xc;

/**
 * @description: 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: YCKJ2932
 * @create: 2021-06-23
 **/
public class Offer15 {
    public static int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000010000000));
    }

    //整型转二进制
//    public void binaryToDecimal(int n) {
//        for (int i = 31; i >= 0; i--) {
//            System.out.print(n >>> i & 1);
//        }
//    }
}
