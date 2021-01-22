package xc.dynamicProcess;

/**
 * @description:
 * @author: YCKJ2932
 * @create: 2021-01-19
 **/
public class DFS {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        String word = "AAB";
        char[] target = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        //可以通过占位符替换原数组中的元素，递归结束后重新恢复赋值
        int flag[][] = new int[m][n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, target, flag, k, i, j)) {
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println("over");
        System.out.println(false);
    }

    private static boolean dfs(char[][] board, char[] target, int[][] flag, int k, int i, int j) {
        System.out.println("k:" + k + " i:" + i + " j:" + j);
        if (k == target.length) {
            System.out.println("符合要求");
            return true;
        } else if (i >= board.length || j >= board[0].length || i < 0 || j < 0) {
            System.out.println("越界i:" + i + " j:" + j);
            return false;
        } else if (flag[i][j] == 1) {
            System.out.println("重复i:" + i + " j:" + j);
            return false;
        } else {
            System.out.println("继续搜索");
            if (board[i][j] == target[k]) {
                flag[i][j] = 1;
                ++k;
                //上下左右位移可以使用二维数组解决
                // int[][] direct = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
                //int newX = x + direct[i][0];
                //int newY = y + direct[i][1];
                boolean res = dfs(board, target, flag, k, i - 1, j) ||
                        dfs(board, target, flag, k, i, j - 1) ||
                        dfs(board, target, flag, k, i + 1, j) ||
                        dfs(board, target, flag, k, i, j + 1);
                flag[i][j] = 0;
                return res;
            } else {
                System.out.println("结束");
                return false;
            }
        }
    }
}
