import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 * 2020/05/01
 */
public class LeetCode200 {
    @Test
    public void name() {
        char[][] grid = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numIslands(grid));
    }

    /**
     * DFS
     * T O(n)
     * S O(1)
     */
    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int count = 0;
        for (int j = 0; j < grid.length; j++) {
            for (int i = 0; i < grid[0].length; i++) {
                if (grid[j][i] == '1') count++;
                dfs(grid, i, j);
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (grid[j][i] == '0') return;

        grid[j][i] = '0';

        if (i - 1 >= 0) dfs(grid, i - 1, j);
        if (j - 1 >= 0) dfs(grid, i, j - 1);
        if (i + 1 < grid[0].length) dfs(grid, i + 1, j);
        if (j + 1 < grid.length) dfs(grid, i, j + 1);
    }
}
