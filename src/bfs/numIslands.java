package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName numIslands
 * @description:
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1：
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 *
 * 示例 2：
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-12-20 18:36
 * @Version 1.0
 **/
public class numIslands {
    // dfs
    public int numIslands1(char[][] grid) {
        int count = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] isIsland = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!isIsland[i][j] && grid[i][j] == '1'){
                    help(isIsland, grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void help(boolean[][] isIsland, char[][] grid, int i, int j) {
        isIsland[i][j] = true;
        // 上
        if(i - 1 >= 0 && grid[i - 1][j] == '1'  && !isIsland[i - 1][j] ) {
            help(isIsland, grid, i - 1, j);
        }
        // 下
        if(i + 1 < grid.length && grid[i + 1][j] == '1' && !isIsland[i + 1][j]) {
            help(isIsland, grid, i + 1, j);
        }
        // 左
        if(j - 1 >= 0 && grid[i][j - 1] == '1'  && !isIsland[i][j - 1]) {
            help(isIsland, grid, i, j - 1);
        }
        // 右
        if(j + 1 < grid[0].length && grid[i][j + 1] == '1'  && !isIsland[i][j + 1]) {
            help(isIsland, grid, i, j + 1);
        }
    }
    // bfs
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }
}
