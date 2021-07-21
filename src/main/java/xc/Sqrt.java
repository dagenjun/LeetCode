package xc;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @description:
 * @author: YCKJ2932
 * @create: 2021-07-15
 **/
public class Sqrt {
    public static double getNumber(double n, double start, double end) {
        double temp = start + (end - start) /2;
        if ( Math.abs(temp * temp - n) < 0.00000001) {
            return BigDecimal.valueOf(temp).setScale(8, BigDecimal.ROUND_HALF_UP).doubleValue();
        } else if (temp * temp > n) {
            end = temp;
        } else {
            start = temp;
        }
        return getNumber(n, start, end);
    }

    /**
     * @param c:
     * @return: double
     * @description: 数学题：t*t=c,循环判断条件是1-c/(t*t)与进度大小，更新条件2*t=c/t+t
     * @author: YCKJ2932
     * @date: 2021/7/15 11:50
     */
    public static double sqrt1(double c) {
        if (c < 0) {
            return Double.NaN;
        } //NaN: not a number
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c / t) > err * t) {
            t = (c / t + t) / 2.0;
        }//t^2接近c, 防止小数

        return t;
    }

    public static void main(String[] args) {
//        System.out.println(getNumber(1, 0, 1));

        System.out.println(sqrt1(0.01));
    }
}
