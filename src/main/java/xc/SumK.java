package xc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 给你无限个范围为 1~m 的数形成一个队列，问最少在前 n 个数的时候， 可以通过加减法计算组合形成 K?(比如说 k=5,给你 2 和 3 可以形成，给你 4 4 3 也可以形成)
 * @author: YCKJ2932
 * @create: 2021-07-06
 **/
public class SumK {
    public static int getTimes(int[] array, int k) {
        Queue<Integer> queue = new LinkedList();
        queue.offer(array[0]);
        boolean isSuccess = false;
        int count;
        for (count = 1; count < array.length; count++) {
            int size = queue.size();
            while (size > 0 && !isSuccess) {
                int num = queue.poll();
                if (num + array[count] == k || num - array[count] == k) {
                    isSuccess = true;
                    break;
                } else {
                    queue.offer(num + array[count]);
                    queue.offer(num - array[count]);
                }
                size--;
            }
            if (isSuccess) {
                break;
            }
        }
        if (isSuccess) {
            return count + 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 2, 3};
        int k = 5;
        System.out.println(getTimes(array, k));
    }
}
