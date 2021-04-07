package hss.basic.dynamicProcess;

/**
 * @author HSS
 * 题目描述：假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死。第一年有 1 只小母牛，从第二年开始，母牛开始生小母牛。每只小母牛 3 年之后成熟又可以生小母牛。给定整数 N，求 N 年后牛的数量。
 */
public class FeiBoNaQiCowProduct {
    private static int CowProduct(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 3;
        }
        int x = 1;
        int y = 3;
        int m = 2;
        //dp[i]=dp[i-1]+dp[i-3]
        for (int i = 4; i < n + 1; i++) {
            int z = x + y;
            x = m;
            m = y;
            y = z;

        }
        return y;
    }

    public static void main(String[] args) {
        System.out.println(CowProduct(6));
    }
}
