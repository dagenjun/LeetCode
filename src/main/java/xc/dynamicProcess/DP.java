package xc.dynamicProcess;

/**
 * Serling公司购买长钢条，将其切割为短钢条出售。切割工序本身没有成本支出。公司管理层希望知道最佳的切割方案。假定我们知道Serling公司出
 * 售一段长为i英寸的钢条的价格为pi(i=1,2,…，单位为美元)。钢条的长度均为整英寸。
 * | 长度i | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 || - | - | - | - | - | - | - | - | - | - |价格pi | 1 | 5 | 8 | 16 | 10 | 17 | 17 | 20 | 24 | 30 |
 * 钢条切割问题是这样的：给定一段长度为n英寸的钢条和一个价格表pi(i=1,2,…n)，求切割钢条方案，使得销售收益rn最大。
 * 注意，如果长度为n英寸的钢条的价格pn足够大，最优解可能就是完全不需要切割
 **/
public class DP {
    static int rec[];

    public static void main(String[] args) {
        //下面使用动态规划来进行解决,关键是要求出变化的量在哪里,我们可以使用excel表格来进行打表帮助我们更好地理解
        //以便求出最佳的切割方案
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int v[] = new int[n];
//        for(int i = 0; i < n; i++){
//            v[i] = sc.nextInt();
//        }
        int n = 10;
        int v[] = {1, 5, 8, 16, 10, 17, 17, 20, 24, 30};
        dp(v, n);
//        sc.close();
    }

    private static void dp(int[] v, int n) {
        rec = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                //前面的是保留的是整对的长度,后面的是需要切割钢条的剩余长度的最佳切割方案
                rec[i] = Math.max(v[j - 1] + rec[i - j], rec[i]);
            }
        }
        System.out.println(rec[n]);
    }

}
