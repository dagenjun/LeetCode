package hss.basic.dynamicProcess;

import java.util.Arrays;

/**
 * @author HSS
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SplitIntegerProduct {
    private static int IntegerProduct(int n) {
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        if (n > 3) {
            for (int i = 4; i <= n; i++) {
                int max = 0;
                for (int j = 1; j < i; j++) {

                    max = Math.max(max, dp[i - j] * j);
                }
                dp[i] = max;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(IntegerProduct(10));
    }
}
