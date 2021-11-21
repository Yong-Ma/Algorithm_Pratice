package dp;

import java.util.Arrays;

/**
 * @ClassName canJump
 * @description:
 * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * 示例1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-10-17 22:45
 * @Version 1.0
 **/
public class canJump {

    // 1、常规做法
    public boolean canJump1(int[] nums) {

        int len = nums.length;
        Boolean[] dp = new Boolean[len];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 0; i < len - 1; i++) {
            int value = nums[i];
            if (!dp[i]) {
                continue;
            }
            for (int j = 1; j <= value; j++) {
                if (i + j >= len) {
                    break;
                }
                dp[i + j] = true;
            }
        }
        return dp[len - 1];
    }
    // 2、贪心
    public boolean canJump2(int[] nums) {

        int len = nums.length;
        // 最远到达的距离
        int maxAccess = 0;
        for (int i = 0; i < len; i++) {
            // 该点可达时
            if (i <= maxAccess) {
                maxAccess = Math.max(maxAccess, nums[i] + i);
                if (maxAccess >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
