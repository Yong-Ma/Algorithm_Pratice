package dp;

import java.util.Arrays;

/**
 * @ClassName CoinChange
 * @description:
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 示例1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 *
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 * 提示：
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2022-02-11 23:56
 * @Version 1.0
 **/
public class CoinChange {

    // 1、递归,会超出时间限制
    private int res = Integer.MAX_VALUE;
    public int coinChange1(int[] coins, int amount) {
        finway(coins, amount, 0);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    private void finway(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res = Math.min(res, count);
        }
        for (int i = 0; i < coins.length; i++) {
            finway(coins, amount - coins[i], count + 1);
        }
    }

    // 2、记忆化搜索
    /**
     * @Description:
     * 复杂度分析
     *
     * 时间复杂度：O(Sn)，其中 S 是金额，n 是面额数。我们一共需要计算 S 个状态的答案，且每个状态 F(S) 由于上面的记忆化的措施只计算了一次，而计算一个状态的答案需要枚举 n 个面额值，所以一共需要 O(Sn) 的时间复杂度。
     * 空间复杂度：O(S)，我们需要额外开一个长为 SS 的数组来存储计算出来的答案 F(S) 。
     *
     * @Author: mzy
     * @Date: 2022/2/12 00:49
     * @param coins:
     * @param amount:
     * @Return int
     **/
    public int coinChange2(int[] coins, int amount) {

        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {

        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = coinChange(coins, rem - coins[i], count);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        count[rem - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return count[rem - 1];
    }

    // 3、动态规划
    public int coinChange3(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i -coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
