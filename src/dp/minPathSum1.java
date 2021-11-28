package dp;

/**
 * 【来源】
 * 书中第四章第二题
 * 【题目】
 * 给定一个矩阵 m，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径
 * 上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
 * 【举例】
 * 如果给定的 m 如下：
 * 1 3 5 9
 * 8 1 3 4
 * 5 0 6 1
 * 8 8 4 0
 *
 * @author yong
 * @date 2021/8/23 21:31
 */
public class minPathSum1 {

    private static int minPathSum(int [][] arr) {

        // 判断非法条件
        if (arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0) {
            return 0;
        }
        int M = arr.length;
        int N = arr[0].length;
        int [][] dp = new int[M][N];
        dp[0][0] = arr[0][0];

        for (int i = 0; i < M ; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j > 0) {
                    dp[i][j] = arr[i][j] + dp[i][j - 1];
                }else if (j == 0 && i > 0) {
                    dp[i][j] = arr[i][j] + dp[i - 1][j];
                }else if(i != 0 && j != 0){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + arr[i][j];
                }
            }
        }
        return dp[M-1][N-1];
    }

    // 测试
    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 5, 9},
                {8, 1, 3, 4},
                {5, 0, 6, 1},
                {8, 8, 4, 0}
        };
        System.out.println("获取左上角到右下角最短路径：" + minPathSum(arr));
    }
}
