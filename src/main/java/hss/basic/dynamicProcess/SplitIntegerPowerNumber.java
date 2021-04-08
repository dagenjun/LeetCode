package hss.basic.dynamicProcess;

import java.util.Arrays;

/**
 * @author HSS
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 *  
 * 提示：
 *
 * 1 <= n <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SplitIntegerPowerNumber {
    private static int IntegerPowerNumber(int n){
//        if(isPow(n)){
//            return 1;
//        }
        int[] dp=new int[n+1];
//        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i=1;i<=n;i++){
//            if(isPow(i)){
//                dp[i]=1;
//            }else {
//                int min=Integer.MAX_VALUE;
            dp[i]=i;
                for(int j=1;j*j<=i;j++){
                    dp[i]=Math.min(dp[i-j*j]+1,dp[i]);
                }

//            }
        }

        return dp[n];
    }

    /**
     * 无需判断是否为完全平方数，因为dp[0]=0而dp[1-1]+1=1,dp[16-16]+1=1可以囊括这些情况
     * @param n
     * @return boolean
     * @author HSS
     * @date 15:38 2021/4/8
     */
    private static boolean isPow(int n){
        if(n<0){
            return false;
        }
        for(int i=1;;i+=2){
            n=n-i;
            if(n==0){
                return true;
            }
            if(n<0){
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isPow(16));
        System.out.println(IntegerPowerNumber(12));
    }
}
