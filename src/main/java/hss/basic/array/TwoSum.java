package hss.basic.array;

import java.util.HashMap;

/**
 * @author HSS
 * @Date: 2021/7/2 10:48
 * @Description: 给定一个数组，给定一个数字。返回数组中可以相加得到指定数字的两个索引。
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,4,5,6,7};
        int sum=5;
        for (int i:TwoSumIndex(nums,sum)){
            System.out.println(i);
        }

    }

    private static int[] TwoSumIndex(int[] nums, int sum) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int target = sum - nums[i];
            if(map.containsKey(target)){
                return new int[]{i,map.get(target)};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
