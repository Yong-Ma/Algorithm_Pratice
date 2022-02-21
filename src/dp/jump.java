package dp;

import java.util.Arrays;

/**
 * @ClassName jump
 * @description:
 * 给你一个非负整数数组nums，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *     从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-10-18 21:44
 * @Version 1.0
 **/
public class jump {

    // 普通解法
    public static int jump(int[] nums) {

        int len = nums.length;
        int[] minAccessTimes = new int[len];
        Arrays.fill(minAccessTimes, Integer.MAX_VALUE);
        minAccessTimes[0] = 0;
        for (int i = 0; i < len - 1; i++) {
            int value = nums[i];
            if (minAccessTimes[i] >= 0 && minAccessTimes[i] != Integer.MAX_VALUE) {
                for (int j = 1; j <= value; j++) {
                    if (i + j > len - 1) {
                        break;
                    }
                    minAccessTimes[i + j] = Math.min(minAccessTimes[i + j], minAccessTimes[i] + 1);
                }
            }
        }
        return minAccessTimes[len - 1];
    }

    // 反向查找-贪心算法1(时间复杂度O(n^2) )
    public static int jump1(int[] nums) {

        int position = nums.length - 1;
        int step = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (nums[i] + i >= position) {
                    step++;
                    position = i;
                    break;
                }
            }
        }
        return step;
    }

    // 正向查找-贪心算法1(时间复杂度O(n) )
    public static int jump2(int[] nums) {

        int end = 0;
        int maxPosition = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }

    // 测试
    public static void main(String[] args) {
        int [] nums = {2,3,1,1,4};
        jump2(nums);
    }
}
