package xc;

import java.util.Arrays;

/**
 * @description: 计算素数
 * @author: YCKJ2932
 * @create: 2021-03-26
 **/
public class countPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(3));
    }
    public static int countPrimes(int n) {
        boolean[] isPrim = new boolean[n+1];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i <= n; i++) {
            if (isPrim[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrim[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrim[i]) {
                count++;
            }
        }

        return count;
    }
}
