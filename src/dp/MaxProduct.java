package dp;

import java.util.Arrays;
import java.util.Map;

/**
 * @ClassName MaxProduct
 * @description:
 * 给你一个整数数组 nums，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释:子数组 [2,3] 有最大乘积 6。
 *
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释:结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2022-01-31 00:20
 * @Version 1.0
 **/
public class MaxProduct {

    public int maxProduct1(int[] nums) {
        int len = nums.length;
        int[] maxDp = new int[len];
        int[] minDp = new int[len];
        System.arraycopy(nums, 0, maxDp, 0, len);
        System.arraycopy(nums, 0, minDp, 0, len);
        for (int i = 1; i < len; i++) {
            maxDp[i] = Math.max(maxDp[i - 1] * nums[i], Math.max(minDp[i - 1] * nums[i], nums[i]));
            minDp[i] = Math.min(minDp[i - 1] * nums[i], Math.min(maxDp[i - 1] * nums[i], nums[i]));
        }
//        int ans = maxDp[0];
//        for (int i = 1; i < len; i++) {
//            ans = Math.max(ans, maxDp[i]);
//        }
//        return ans;
        // 以下java8流所耗费时间更长
        return Arrays.stream(maxDp).max().orElse(0);
    }

    public int maxProduct2(int[] nums) {
        int len = nums.length;
        int maxDp = nums[0];
        int minDp = nums[0];
        int ans = nums[0];
        for (int i = 1; i < len; i++) {
            int mx = maxDp, mn = minDp;
            maxDp = Math.max(mx * nums[i], Math.max(mn * nums[i], nums[i]));
            minDp = Math.min(mn * nums[i], Math.min(mx * nums[i], nums[i]));
            ans = Math.max(ans, maxDp);
        }
        return ans;
    }
}
