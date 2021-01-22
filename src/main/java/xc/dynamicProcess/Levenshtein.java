package xc.dynamicProcess;

import java.util.Scanner;

/**
 * Levenshtein Distance就是两个字符串A,B,我们需要使用原子操作将A转换为B：
 *
 * 字符串删除
 * 字符串插入
 * 字符替换（从技术上讲，它不止一个操作，但为了简单起见，我们称之为原子操作）
 *
 * 这个问题是通过有条理地解决起始字符串的子串的问题来处理的，逐渐增加子字符串的大小，直到它们等于起始字符串。
 *
 * 我们用于此问题的递归关系如下：
 *
 * 如果
 * a == b则
 * c（a，b）为0，如果
 * a != b则
 * c（a，b）为1。
 **/
public class Levenshtein {
    public static void main(String[] args) {
        String s1, s2;
        Scanner scanner = new Scanner(System.in);
        s1 = scanner.next();
        System.out.println("Insert second string:");
        s2 = scanner.next();

        int n, m;
        n = s1.length();
        m = s2.length();
        int[][] distance = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            distance[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            distance[0][j] = j;
        }

        int e1, e2, e3, min;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                e1 = distance[i - 1][j] + 1;
                e2 = distance[i][j - 1] + 1;
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    e3 = distance[i - 1][j - 1];
                } else {
                    e3 = distance[i - 1][j - 1] + 1;
                }
                min = Math.min(e1, e2);
                min = Math.min(min, e3);
                distance[i][j] = min;
            }

        }
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[i].length; j++) {
                System.out.print("[" + distance[i][j] + "] ");
            }
            System.out.println();
        }
        System.out.println("Edit distance of s1 and s2 is: " + distance[n][m]);

        System.out.println(editDistance(s2,s1));
    }
    public static int editDistance(String source, String target) {
        int sourceLen = source.length();
        int targetLen = target.length();

        if (sourceLen == 0) {
            return targetLen;
        }
        if (targetLen == 0) {
            return sourceLen;
        }

        //定义矩阵(二维数组)
        int[][] arr = new int[sourceLen + 1][targetLen + 1];

        for (int i = 0; i < sourceLen + 1; i++) {
            arr[i][0] = i;
        }
        for (int j = 0; j < targetLen + 1; j++) {
            arr[0][j] = j;
        }

        Character sourceChar = null;
        Character targetChar = null;

        for (int i = 1; i < sourceLen + 1; i++) {
            sourceChar = source.charAt(i - 1);

            for (int j = 1; j < targetLen + 1; j++) {
                targetChar = target.charAt(j - 1);

                if (sourceChar.equals(targetChar)) {
                    /*
                     *  如果source[i] 等于target[j]，则：d[i, j] = d[i-1, j-1] + 0          （递推式 1）
                     */
                    arr[i][j] = arr[i - 1][j - 1];
                } else {
                    /*  如果source[i] 不等于target[j]，则根据插入、删除和替换三个策略，分别计算出使用三种策略得到的编辑距离，然后取最小的一个：
                        d[i, j] = min(d[i, j - 1] + 1, d[i - 1, j] + 1, d[i - 1, j - 1] + 1 )    （递推式 2）
                        >> d[i, j - 1] + 1 表示对source[i]执行插入操作后计算最小编辑距离
                        >> d[i - 1, j] + 1 表示对source[i]执行删除操作后计算最小编辑距离
                        >> d[i - 1, j - 1] + 1表示对source[i]替换成target[i]操作后计算最小编辑距离
                    */
                    arr[i][j] = (Math.min(Math.min(arr[i - 1][j], arr[i][j - 1]), arr[i - 1][j - 1])) + 1;
                }
            }
        }

        return arr[sourceLen][targetLen];
    }
}
