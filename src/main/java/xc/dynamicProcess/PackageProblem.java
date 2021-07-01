package xc.dynamicProcess;

/**
 * @description: 吉他价值1500，占容量1，笔记本电脑价值2000，占容量3，音响价值3000，占容量4。
 * 思路：
 * 先初始化一种商品在不同背包容量下的价值，然后在叠加一个商品，比较当前背包是否可以容纳下现有商品，根据空间找到对应的价值，
 * 如果能装下，也就是当前价值+剩余空间可换取的价值，需要和不装当前商品时，同一容量背包的价值(数组的同一列上一行)比较，取最大值，
 * 如果当前背包装不下，说明只能放下除现有商品，及之前的所有商品，也就是数组的同一列上一行
 * @author: YCKJ2932
 * @create: 2021-06-24
 **/
public class PackageProblem {
    private int cap;
    private BagObject[] objs;
    private int[][] dp;

    public PackageProblem(int bagCap, BagObject[] objs) {
        // TODO Auto-generated constructor stub
        cap = bagCap;
        this.objs = objs;
        dp = new int[this.objs.length + 1][cap + 1];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BagObject guiter = new BagObject(1, 1500);
        BagObject tap = new BagObject(3, 2000);
        BagObject radio = new BagObject(4, 3000);
        BagObject[] objs = new BagObject[3];
        objs[2] = guiter;
        objs[1] = tap;
        objs[0] = radio;
        PackageProblem pp = new PackageProblem(4, objs);
        System.out.println("result:" + pp.getMaxValue());
    }

    public int getMaxValue() {
        int nowval = objs[0].value;
        int nowcap = objs[0].capaticy;
        int i, j;
        for (i = 1; i <= cap; i++) {
            if (i >= nowcap) {
                dp[1][i] = nowval;
            }
        }
        for (i = 2; i <= this.objs.length; i++) {
            nowcap = objs[i-1].capaticy;
            nowval = objs[i-1].value;
            for (j = 1; j <= cap; j++) {
                if (j - nowcap >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], nowval + dp[i - 1][j - nowcap]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int m = 0; m <= 3; m++) {
            for (int n = 0; n <= 4; n++) {
                System.out.print(dp[m][n] + " ");
            }
            System.out.println();
        }


        return dp[objs.length][cap];
    }
}
