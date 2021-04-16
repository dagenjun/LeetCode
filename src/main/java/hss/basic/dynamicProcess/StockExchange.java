package hss.basic.dynamicProcess;

/**
 * @author HSS
 * @Date: 2021/4/15 17:09
 * @Description: 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 * <p>
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StockExchange {
    public static void main(String[] args) {
        System.out.println(stockExchange(new int[]{1,2,3,0,2}));
    }

    private static int stockExchange(int[] prices) {
        int n = prices.length;
        int[][] fi = new int[n][3];
        fi[0][0] = -prices[0];
        fi[0][1] = 0;
        fi[0][2] = 0;
        for (int i = 1; i < n; i++) {
            //股票在手上的最大收益
            fi[i][0] = Math.max(fi[i - 1][0], fi[i - 1][2] - prices[i]);
            //股票不在手上但是在冷却期的最大收益
            fi[i][1] = fi[i - 1][0] + prices[i];
            //股票不在手上但是不在冷却期的最大收益
            fi[i][2] = Math.max(fi[i - 1][2], fi[i - 1][1]);
        }
        return Math.max(fi[n-1][1],fi[n-1][2]);
    }
}
