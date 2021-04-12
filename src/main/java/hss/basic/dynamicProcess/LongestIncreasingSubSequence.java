package hss.basic.dynamicProcess;

/**
 * @author HSS
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *  
 * <p>
 * 进阶：
 * <p>
 * 你可以设计时间复杂度为 O(n2) 的解决方案吗？
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestIncreasingSubSequence {
    /**
     * O(n^2)
     *
     * @param nums
     * @return int
     * @author YCKJ3552
     * @date 17:27 2021/4/9
     */
    private static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int res = 1;
        for (int i = 2; i <= n; i++) {
            int max = 1;

            for (int j = 1; j < i; j++) {
                if (nums[i - 1] > nums[j - 1]) {
                    max = Math.max(dp[j] + 1, max);
                }
            }
            dp[i] = max;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 贪心+二分查找
     * 维护一个长度为i的数组，d[i]表示长度为 i的最长上升子序列的末尾元素的最小值
     *
     * @param nums
     * @return int
     * @author YCKJ3552
     * @date 18:08 2021/4/9
     */
    private static int BinarySearchLengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] d = new int[n + 1];
        d[1] = nums[0];
        int len = 1;
        if (n == 1) {
            return 1;
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                binarySearch(d, nums[i], len);
            }
        }
        return len;

    }

    private static void binarySearch(int[] d, int num, int len) {
        int l = 1;
        int r = len;
        int pos = 0;
        while (l <= r) {
            int mid = l + (r - l) >> 2;
            if(d[mid]<num){
                pos=mid;
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        d[pos+1]=num;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }
}
