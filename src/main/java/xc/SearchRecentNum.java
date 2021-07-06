package xc;

import java.util.ArrayList;
import java.util.List;


/**
 * @description: N 个数的有序求组，找到中间的某个数 k, 找到距离 k 最近的 c 个数，返回最小 值和最大值 e.g. 数组 1 2 3 4 7 8 10 11.
 * K=7. 找到离 k 最近的 3 个数(与 7 的绝对值最小). 结果[4，10]
 * @author: YCKJ2932
 * @create: 2021-07-02
 **/
public class SearchRecentNum {
    public static List<Integer> search(int[] array, int k, int c) {
        List<Integer> result = new ArrayList<>(2);
        if (c > array.length - 2) {
            return result;
        }
        int low = 0;
        int high = array.length - 1;
        int index = myBinarySearch(array, k, low, high);
        if (index < 0) {
            return result;
        }
        int count = 0;
        int left = index - 1;
        int right = index + 1;
        while (count < c) {
            if (index == array.length - 1) {
                left -= c;
                right--;
                break;
            } else if (index == 0) {
                right += c;
                left++;
                break;
            } else if (k - array[left] < array[right] - k || right > array.length - 1) {
                left--;
            } else {
                right++;
            }
            count++;
        }
        result.add(array[left + 1]);
        result.add(array[right - 1]);
        return result;
    }

    private static int myBinarySearch(int[] array, int k, int low, int high) {
        if (low > high) {
            return -1;
        } else {
            int mid = low + (high - low) / 2;
            if (array[mid] == k) {
                return mid;
            } else if (array[mid] < k) {
                return myBinarySearch(array, k, mid + 1, high);
            } else {
                return myBinarySearch(array, k, low, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println(search(array, 1, 3));
    }
}
