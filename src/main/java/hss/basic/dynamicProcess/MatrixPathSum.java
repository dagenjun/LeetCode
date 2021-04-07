package hss.basic.dynamicProcess;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author HSS
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j])+grid[i][j]
 */
public class MatrixPathSum {
    private static int[][] PathSum(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(i==0&&j==0){

                    continue;
                }else if(i==0){

                    grid[i][j]=grid[i][j-1]+grid[i][j];
                }else if(j==0){

                    grid[i][j]=grid[i-1][j]+grid[i][j];
                }else{
                    grid[i][j]=Math.min(grid[i][j-1],grid[i-1][j])+grid[i][j];
                }
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] res=PathSum(grid);
        for(int i=0;i<res.length;i++){
            System.out.println(Arrays.asList(res[i]));

        }
    }


}
