package xc;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xuchao
 * @description: 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @program: leetcode_share
 * @date 2021/6/26 13:56
 **/
public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int tail = -1;
        for (int i = 0; i < s.length(); i++) {
            if(i!=0){
                set.remove(s.charAt(i-1));
            }
            while(tail+1<s.length()&&!set.contains(s.charAt(tail+1))){
                set.add(s.charAt(tail+1));
                tail++;
            }
            max=Math.max(max,tail-i+1);
        }
        return max;
    }
}
