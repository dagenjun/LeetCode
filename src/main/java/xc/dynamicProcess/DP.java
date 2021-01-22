package xc.dynamicProcess;

import jdk.nashorn.internal.parser.JSONParser;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: YCKJ2932
 * @create: 2021-01-15
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
