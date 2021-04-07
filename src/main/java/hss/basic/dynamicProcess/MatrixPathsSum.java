package hss.basic.dynamicProcess;

/**
 * @author HSS
 * 题目描述：统计从矩阵左上角到右下角的路径总数，每次只能向右或者向下移动。
 */
public class MatrixPathsSum {
    private static int[][] PathsSum(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(i==0&&j==0){


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
}
