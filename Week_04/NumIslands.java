package cs.com.examination.test.week04;

/**
 * Created by chenshun on 2020/10/25.
 * 200. 岛屿数量
 */

public class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }

        int count = 0;
        int rowSize = grid.length;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }


    private void dfs(char[][] grid, int r, int c) {
        int rowSize = grid.length;
        int colSize = grid[0].length;

        if (r < 0 || c < 0 || r >= rowSize || c >= colSize || grid[r][c] == '0') {
            //碰到水，往回走
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);//寻找上
        dfs(grid, r + 1, c);//寻找下
        dfs(grid, r, c - 1);//寻找左
        dfs(grid, r, c + 1);//寻找右
    }
}
