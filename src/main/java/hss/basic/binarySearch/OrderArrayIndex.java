package hss.basic.binarySearch;

/**
 * @author HSS
 * @Date: 2021/7/2 10:25
 * @Description: 求有序数组中比目标值大的下一个 index eg：数组：{1,3,5,5,5,5,5,6,7,8}，
 * 目标值 5；答案为元素 6 的序号：7。 这里我用二分查找实现的，面试官说不是最优答案，问有没有优化的方法？
 */
public class OrderArrayIndex {
    public static void main(String[] args) {
        int[] n=new int[]{1,3,5,5,5,5,5,6,7,8};
        int t=5;
        int i = binarySearch(n, t);
        System.out.println("元素为"+n[i]+"的序号："+i);
    }

    private static int binarySearch(int[] n,int t) {
        int lf = 0, rt = n.length - 1;
        while (lf <= rt) {
            int mid = lf + (rt - lf) / 2;
            if (n[mid] > t) {
                rt = mid - 1;
            } else {
                lf = mid + 1;
            }
        }
        return lf;
    }
}

