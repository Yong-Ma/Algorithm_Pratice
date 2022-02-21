package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName lengthOfLIS
 * @description:
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 *
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *
 * 提示：
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-12-31 22:33
 * @Version 1.0
 **/
public class lengthOfLIS {

    // 暴力
    public static int lengthOfLIS1(int[] nums) {
        // 获取数组中每个位置上比这个位置的数还大的序列集合
        HashMap<Integer, List<Integer>> mapOfBiggerNums = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            ArrayList<Integer> biggerNums = new ArrayList<>();
            for (int j = i + 1; j < len; j++) {
                if (nums[j] >= nums[i]) {
                    biggerNums.add(j);
                }
            }
            mapOfBiggerNums.put(i, biggerNums);
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = len - 1; i >= 0; i--) {
            List<Integer> list = mapOfBiggerNums.get(i);
            int max = 0;
            for (int j = 0; j < list.size(); j++) {
                max = Math.max(max, dp[list.get(j)]);
            }
            dp[i] = max + 1;
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    // 测试
    public static void main(String[] args) {
        int [] nums = new int[]{10,9,2,5,3,7,101,18};
        lengthOfLIS1(nums);
    }
    // 动态规划
    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int maxAns = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }

}
