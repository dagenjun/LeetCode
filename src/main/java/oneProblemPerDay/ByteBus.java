package oneProblemPerDay;

/**
 * @author YCKJ3563
 * @date 2021年07月02日 11:03
 */
public class ByteBus {

    public static void main(String[] args) {
        ByteBus issue = new ByteBus();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(issue.canCompleteCircuit(gas, cost));
    }

    /**
     * 字节跳动在北京有 N 个工区，形成一个环状，Bytebus 是往返在各个工区的通勤 车，按工区的顺序行驶，其中第 i 个工区有汽油 gas[i] 升。你有一辆油箱容 量无限的 Bytebus，从第 i 个工区开往第 i+1 个工区需要消耗汽油 cost[i] 升。你从其中的一个工区出发，开始时油箱为空，可以使用当前工区的汽油 gas[i] 升。如果你可以绕环路行驶一周，则返回出发时工区的编号，否则返回 -1。 输入：gas = [1,2,3,4,5] cost = [3,4,5,1,2] 输出：3
     *
     * @param gas
     * @param cost
     * @return int
     * @author YCKJ3563
     * @date 17:40 2021/7/1
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int start = 0; start < n; start++) {
            // 直接跳过第一步都不满足的起点
            if (gas[start] < cost[start]) continue;
            // 剩余油量
            int cur = gas[start] - cost[start];
            // 所在位置
            int idx = (start + 1) % n;
            while (idx != start) {
                cur += gas[idx] - cost[idx];
                // 如果剩余油量为负数，说明无法离开当前位置，走到下一位置
                if (cur < 0) break;
                idx = (idx + 1) % n;
            }
            if (idx == start) return start;
        }
        return -1;
    }
}
