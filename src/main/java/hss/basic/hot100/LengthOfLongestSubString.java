package hss.basic.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author HSS
 * @Date: 2021/7/12 13:31
 * @Description: 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class LengthOfLongestSubString {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubString("pwwkew"));
    }

    private static int lengthOfLongestSubString(String s) {
        int length = s.length();
        Set con = new HashSet();
        int res = 0;
        int left = 0;
        int right = 0;
        while (left < length && right < length) {
            while (right<length&&!con.contains(s.charAt(right))) {
                con.add(s.charAt(right));
                right++;
            }
            res=Math.max(res,right-left);
            con.remove(s.charAt(left));
            left++;

        }

        return res;
    }
}
