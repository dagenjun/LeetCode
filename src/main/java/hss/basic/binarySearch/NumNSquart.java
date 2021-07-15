package hss.basic.binarySearch;

import java.math.BigDecimal;

/**
 * @author HSS
 * @Date: 2021/7/15 10:38
 * @Description:
 */
public class NumNSquart {
    public static void main(String[] args) {
        System.out.println(sqrt(-0.01, 8));
        System.out.println(Math.sqrt(0.01));
        System.out.println(sqrt1(2, 8));
    }

    /**
     * 二分法没有办法处理<1的情况
     * @param n
     * @param precision
     * @return double
     * @author YCKJ3552
     * @date 11:50 2021/7/15
     */
    public static double sqrt(double n, int precision) {
        if (n < 0) {
            return Double.NaN;
        }
        double lower = 0;
        double high = n;
        double mid = 0;
        double threshold = Math.pow(10, -precision);
//        do{
//            mid = lower + (high - lower)/2;
//            if(mid*mid > n){
//                high = mid;
//            }else{
//                lower = mid;
//            }
//
//        }while (Math.abs(mid*mid-n) > threshold);
        while (Math.abs(mid * mid - n) > threshold) {
            mid = lower + (high - lower) / 2;
            if (mid * mid > n) {
                high = mid;
            } else {
                lower = mid;
            }

        }


        return new BigDecimal(mid).setScale(precision, BigDecimal.ROUND_DOWN).doubleValue();
    }

    /**
     * 正确解法
     * @param c
     * @param n
     * @return double
     * @author YCKJ3552
     * @date 11:49 2021/7/15
     */
    public static double sqrt1(double c, int n) {
        if (c < 0) {
            return Double.NaN;
        } //NaN: not a number
        double err = Math.pow(10, -n);
        double t = c;
        while (Math.abs(t * t - c) > err) {
            t = (c / t + 2 * t) / 3;
        }//t^2接近c, 防止小数

        return new BigDecimal(t).setScale(n, BigDecimal.ROUND_DOWN).doubleValue();
    }

}
