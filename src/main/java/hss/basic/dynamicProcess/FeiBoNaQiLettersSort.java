package hss.basic.dynamicProcess;

/**
 * @author HSS
 * 题目描述：有 N 个 信 和 信封，它们被打乱，求错误装信方式的数量。
 * dp[i]=(i-1)dp[i-2]+(i-1)dp[i-2]
 */
public class FeiBoNaQiLettersSort {
    private static int LettersSort(int n){
        int x=0;
        int y=1;
        for(int i=3;i<n+1;i++){
            int z=(i-1)*(x+y);
            x=y;
            y=z;
        }
        return y;
    }

    public static void main(String[] args) {
        System.out.println(LettersSort(4));
    }
}
