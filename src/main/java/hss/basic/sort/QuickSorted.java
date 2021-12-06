package hss.basic.sort;

import java.util.Arrays;
import java.util.concurrent.Executors;

public class QuickSorted {
    public static void main(String[] args) {
        int[] nums = new int[]{49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int index = getIndex(nums, left, right);
            quickSort(nums, left, index - 1);
            quickSort(nums, index + 1, right);
        }

    }

    private static int getIndex(int[] nums, int left, int right) {
        int tmp=nums[left];
        while (left < right) {

            while(left<right&&nums[right]>=tmp){
                right--;
            }
            nums[left]=nums[right];
            while(left<right&&nums[left]<=tmp){
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left]=tmp;
        return left;
    }
}
