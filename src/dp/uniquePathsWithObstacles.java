package dp;

/**
 * @ClassName uniquePathsWithObstacles
 * @description:
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-11-03 22:48
 * @Version 1.0
 **/
public class uniquePathsWithObstacles {

    // 繁琐的做法
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        if (obstacleGrid[0][0] == 1) {
            dp[0][0] = Integer.MAX_VALUE;
        }else {
            dp[0][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            // 第一列的路径只能从上边过来
            if (obstacleGrid[i][0] == 1 || dp[i - 1][0] == Integer.MAX_VALUE) {
                // 整数最大值代表有障碍物不能通过
                dp[i][0] = Integer.MAX_VALUE;
            }else {
                dp[i][0] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            // 第一行的路径只能从左边来
            if (obstacleGrid[0][i] == 1 || dp[0][i - 1] == Integer.MAX_VALUE) {
                // 整数最大值代表有障碍物不能通过
                dp[0][i] = Integer.MAX_VALUE;
            } else {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i - 1][j] == Integer.MAX_VALUE && dp[i][j - 1] != Integer.MAX_VALUE && obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i][j - 1];
                }else if (dp[i - 1][j] != Integer.MAX_VALUE && dp[i][j - 1] == Integer.MAX_VALUE && obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j];
                }else if (dp[i - 1][j] != Integer.MAX_VALUE && dp[i][j - 1] != Integer.MAX_VALUE && obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }else {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        return dp[m - 1][n -1] == Integer.MAX_VALUE ? 0 : dp[m - 1][n -1];
    }

    // 优化1，时间和空间复杂度仍为O（mn）
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        if (obstacleGrid[0][0] == 0) {
            dp[0][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = dp[0][i -1];
            }
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    // 使用滚动数组的方式降低空间复杂度为O（m）
    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] dp = new int[m];
        if (obstacleGrid[0][0] == 0) {
            dp[0] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    dp[j] += dp[j -1];
                }
            }
        }
        return dp[m - 1];
    }
}
