package dfs;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 示例1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gaM7Ch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yong
 * @date 2021/8/26 22:02
 */
public class coinChange {

    public int coinChange(int[] coins, int amount) {
        // 特殊情况判断
        if (amount == 0) {
            return 0;
        }
        // dp[i]表示凑成金额i所需要的硬币数量，初始值设为amount+1,即兑换最坏情况是全是1元硬币，amount+1相当于无限
        int [] dp = new int[amount+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = amount+1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int v : coins) {
                if (i < v) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i-v] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
