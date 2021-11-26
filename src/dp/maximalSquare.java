package dp;

/**
 * @ClassName maximalSquare
 * @description:
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-11-27 00:44
 * @Version 1.0
 **/
public class maximalSquare {

     // 暴力解法的优化
    public int maximalSquare1(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        // 正方形可能的最大边长
        int perhapsLen = Math.min(rows, cols);
        boolean[][][] dp = new boolean[rows][cols][perhapsLen];
        // 最大正方形边长
        int maxSideLen = 0;
        // 初始化
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = matrix[i][j];
                if (c == '1') {
                    dp[i][j][0] = true;
                    maxSideLen = 1;
                }
            }
        }
        // 没有字符'1'
        if (maxSideLen == 0) {
            return 0;
        }
        for (int i = 2; i <= perhapsLen; i++) {
            for (int j = 0; j <= rows - i; j++) {
                for (int k = 0; k <= cols - i; k++) {
                    boolean first = dp[j][k][i - 2];
                    boolean second = dp[j][k + 1][i - 2];
                    boolean third = dp[j + 1][k][i - 2];
                    boolean four = dp[j + 1][k + 1][i - 2];
                    if (first && second && third && four) {
                        dp[j][k][i - 1] = true;
                        maxSideLen = i;
                    }
                }
            }
        }
        return (int) Math.pow(maxSideLen, 2);
    }
    // 动态规划
    public int maximalSquare2(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

}
