package cs.com.examination.test.week06;

/**
 * Created by chenshun on 2020/11/8.
 * 64. 最小路径和
 */

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;//行
        int col = grid[0].length;//列

        int dp[][] = new int[row][col];//某个点的最小路径和

        //由于只能向下或者向右，因此第一行和第一列的最小路径和可以直接求出
        dp[0][0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }

        for (int i = 1; i < col; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        //接着求非第一行，第一列
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }

        return dp[row - 1][col - 1];
    }
}
