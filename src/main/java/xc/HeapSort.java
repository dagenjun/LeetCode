package xc;

import java.util.Arrays;

/**
 * @description:
 * @author: YCKJ2932
 * @create: 2021-07-07
 **/
public class HeapSort {

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 5, 1, 2, 6};
        System.out.println(Arrays.toString(sort(array)));
    }

    private static int[] sort(int[] array) {
        int len = array.length;
        buildMaxHeap(array, len);
        for (int i = len - 1; i >= 0; i--) {
            swap(array, 0, i);
            len--;
            heapify(array, 0, len);
        }
        return array;
    }

    private static void buildMaxHeap(int[] array, int len) {
        for (int i = len / 2; i >= 0; i--) {
            heapify(array, i, len);
        }
    }

    private static void heapify(int[] array, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < len && array[left] > array[max]) {
            max = left;
        }
        if (right < len && array[right] > array[max]) {
            max = right;
        }
        if (max != i) {
            swap(array, i, max);
            heapify(array, max, len);
        }
    }

    private static void swap(int[] array, int i, int max) {
        int temp = array[i];
        array[i] = array[max];
        array[max] = temp;
    }
}
