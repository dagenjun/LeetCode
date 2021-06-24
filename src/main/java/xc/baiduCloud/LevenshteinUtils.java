package xc.baiduCloud;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author YCKJ1588
 * @ClassName LevenshteinUtils
 * @Description: 编辑距离（Levenshtein）,用于计算两个字符串之间的准确率
 * @date 2020/10/14
 **/
public class LevenshteinUtils {
    private LevenshteinUtils() {
    }

    /**
     * 计算两个字符串的相似度
     *
     * @param sourceText 比较字符串
     * @param tagText    基准字符串
     * @return java.lang.Double
     * @author YCKJ1588
     * @date 15:24 2020/10/14
     */
    public static Double getSimilarity(String sourceText, String tagText) {
        if (StringUtils.isBlank(sourceText) || StringUtils.isBlank(tagText)) {
            return 0d;
        }
        double distance = editDistance(sourceText, tagText);
        double maxLength = Math.max(sourceText.length(), tagText.length());
        return (maxLength - distance) / maxLength;
    }

    /**
     * 计算两个字符串的编辑距离
     *
     * @param source 比较字符串
     * @param target 基准字符串
     * @return int
     * @author YCKJ1588
     * @date 15:24 2020/10/14
     */
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
