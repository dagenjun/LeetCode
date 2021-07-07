package hss.basic.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author HSS
 * @Date: 2021/7/2 11:03
 * @Description: N 个数的有序求组，找到中间的某个数 k, 找到距离 k 最近的 c 个数，返回最小 值和最大值
 * e.g. 数组 1 2 3 4 7 8 10 11. K=7. 找到离 k 最近的 3 个数(与 7 的绝对值最小). 结果[4，10]
 */
public class ArrayNearest {
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,4,7,8,10,11};
        int index=Arrays.binarySearch(nums,7);
        System.out.println(index);

    }

    private static int[] ArrayNearest1(int[] nums, int K, int c) {

        for (int i = 0; i < nums.length - c; i++) {
            int max=Integer.MAX_VALUE;
            int[] res=new int[nums.length-c];
            for (int j = 0; j < c; j++) {
                res[i]=res[i]+Math.abs(nums[i] - K);
            }
        }
        return new int[]{1};
    }

    private static int[] ArrayNearest2(int[] nums, int K, int c) {
        return new int[]{1};
    }
}
