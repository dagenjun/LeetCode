package xc;

import java.util.Arrays;

/**
 * @description: 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * @author: YCKJ2932
 * @create: 2021-07-06
 **/
public class Leetcode41 {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,4,-1,1};
        System.out.println(firstMissingPositive(array));
    }
}
