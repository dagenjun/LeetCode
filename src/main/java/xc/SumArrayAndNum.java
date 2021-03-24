package xc;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: YCKJ2932
 * @create: 2021-01-22
 **/
public class SumArrayAndNum {
    public static void main(String[] args) {
        int[] A = {0};
        int b = 1000;
        char[] sourceB = String.valueOf(b).toCharArray();
        int resLen = A.length > sourceB.length ? A.length : sourceB.length;
        List<Integer> res = new ArrayList<>(resLen + 1);
        int flag = 0;
        for (int i = resLen - 1; i >= 0; i--) {
            int tmp = 0;
            if (i - resLen + A.length >= 0) {
                tmp += A[i - resLen + A.length];
            } else {
                tmp += 0;
            }

            if (i - resLen + sourceB.length >= 0) {
                tmp += Integer.valueOf(String.valueOf(sourceB[i - resLen + sourceB.length]));
            } else {
                tmp += 0;
            }
            if (flag == 1) {
                tmp += 1;
                flag = 0;
            }
            if (tmp >= 10) {
                res.add(0, tmp - 10);
                flag = 1;
            } else {
                res.add(0, tmp);
            }
        }
        if (flag == 1) {
            res.add(0, flag);
        }
        System.out.println(res);
    }
}
