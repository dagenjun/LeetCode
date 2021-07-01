package xc.dynamicProcess;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、
 * 右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 */
public class DFS {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        String word = "AAB";
        System.out.println(exist(board,word));
    }

        public static boolean exist(char[][] board, String word) {
            int h = board.length, w = board[0].length;
            boolean[][] visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    boolean flag = check(board, visited, i, j, word, 0);
                    if (flag) {
                        return true;
                    }
                }
            }
            return false;
        }

        public static boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
            if (board[i][j] != s.charAt(k)) {
                return false;
            } else if (k == s.length() - 1) {
                return true;
            }
            visited[i][j] = true;
            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            boolean result = false;
            for (int[] dir : directions) {
                int newi = i + dir[0], newj = j + dir[1];
                if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                    if (!visited[newi][newj]) {
                        boolean flag = check(board, visited, newi, newj, s, k + 1);
                        if (flag) {
                            result = true;
                            break;
                        }
                    }
                }
            }
            visited[i][j] = false;
            return result;
        }
        //解法数据量大时超时
//    public static boolean exist(char[][] board, String word) {
//        char[] target = word.toCharArray();
//        int m = board.length;
//        int n = board[0].length;
//        //可以通过占位符替换原数组中的元素，递归结束后重新恢复赋值
//        int flag[][] = new int[m][n];
//        int k = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (dfs(board, target, flag, k, i, j)) {
//                    System.out.println(true);
//                    return;
//                }
//            }
//        }
//        System.out.println("over");
//        System.out.println(false);
//    }
//
//    private static boolean dfs(char[][] board, char[] target, int[][] flag, int k, int i, int j) {
//        System.out.println("k:" + k + " i:" + i + " j:" + j);
//        if (k == target.length) {
//            System.out.println("符合要求");
//            return true;
//        } else if (i >= board.length || j >= board[0].length || i < 0 || j < 0) {
//            System.out.println("越界i:" + i + " j:" + j);
//            return false;
//        } else if (flag[i][j] == 1) {
//            System.out.println("重复i:" + i + " j:" + j);
//            return false;
//        } else {
//            System.out.println("继续搜索");
//            if (board[i][j] == target[k]) {
//                flag[i][j] = 1;
//                ++k;
//                //上下左右位移可以使用二维数组解决
//                // int[][] direct = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
//                //int newX = x + direct[i][0];
//                //int newY = y + direct[i][1];
//                boolean res = dfs(board, target, flag, k, i - 1, j) ||
//                        dfs(board, target, flag, k, i, j - 1) ||
//                        dfs(board, target, flag, k, i + 1, j) ||
//                        dfs(board, target, flag, k, i, j + 1);
//                flag[i][j] = 0;
//                return res;
//            } else {
//                System.out.println("结束");
//                return false;
//            }
//        }
//    }

}
