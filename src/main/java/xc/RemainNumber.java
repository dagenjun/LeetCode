package xc;

import java.util.Arrays;

/**
 * @description: 100 个人围成一个圈，依次 1，2，3 报数，数到 3 的时候下去一个，最后 留下的是几号
 * @author: YCKJ2932
 * @create: 2021-07-06
 **/
public class RemainNumber {
    public static int getNum(int n) {
        int count = n;
        int[] array = new int[101];
        Arrays.fill(array, 1);
        int num = 1;
        for (int i = 1; count != 1; i++) {
            if (i > n) {
                i = 1;
            }
            if (array[i] == 0) {
                continue;
            }
            if (num % 3 == 0) {
                array[i] = 0;
                count--;
                num = 1;
            } else {
                num++;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (array[i] != 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getNum(100));
    }
}
