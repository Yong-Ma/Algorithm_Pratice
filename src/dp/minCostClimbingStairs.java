package dp;

/**
 * @ClassName minCostClimbingStairs
 * @description:
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值cost[i]（下标从 0 开始）。
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 *
 * 示例1：
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 *
 * 示例 2：
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-09-22 21:12
 * @Version 1.0
 **/
public class minCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {

        // 每个dp的值表示处于该层所需花费的最小体力
        int len = cost.length;
        int [] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < len + 1; i++) {
            dp[i] = Math.min(dp[i -1] + cost[i-1], dp[i -2]+ cost[i - 2]) ;
        }
        return dp[len];
    }
}
