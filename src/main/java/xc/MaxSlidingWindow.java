package xc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @description: 一个数组 加一个常数 k k 是窗口 滑动 找出滑动窗口最大值 不能用系统函数
 * @author: YCKJ2932
 * @create: 2021-07-06
 **/
public class MaxSlidingWindow {
    public static List<Integer> maxSlidingWindow(int[] array, int k) {
        if (Objects.isNull(array) || array.length < k) {
            return new ArrayList<>(0);
        }
        List<Integer> result = new ArrayList<>(array.length - k + 1);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= array.length - k; i++) {
            for (int j = i; j < i + k; j++) {
                if (max < array[j]) {
                    max = array[j];
                }
            }
            result.add(max);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(maxSlidingWindow(array, k));
    }
}
