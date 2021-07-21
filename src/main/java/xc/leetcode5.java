package xc;

/**
 * @description:
 * @author: YCKJ2932
 * @create: 2021-07-12
 **/
public class leetcode5 {
    static int max = 0;
    static int min = 0;

    public static String longestPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int head = i;
            int tail = i;
            while (head >= 0 && tail < n) {
                check(s, head, tail);
                head--;
                tail++;
            }
        }
        return s.substring(min, max+1);
    }

    private static void check(String s, int i, int j) {
        String substring = s.substring(i, j+1);
        int head = 0;
        int tail = substring.length() - 1;
        while (head < tail) {
            if (substring.charAt(head) == substring.charAt(tail)) {
                head++;
                tail--;
            }else {
                return;
            }
        }
        if (j - i > max - min) {
            min = i;
            max = j;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
