package array;

/**
 * @ClassName FindDuplicate
 * @description:
 * 给定一个包含n + 1 个整数的数组nums ，其数字都在[1, n]范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回这个重复的数 。
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 *
 * 示例 1：
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 *
 * 示例 2：
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 *
 * 提示：
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2022-02-10 20:56
 * @Version 1.0
 **/
public class FindDuplicate {

    // 1、双重循环暴力解法，超出时间限制
    public int findDuplicate1(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    // 2、二分查找，时间复杂度为O（N * log N）
    public int findDuplicate2(int[] nums) {
        int len = nums.length;
        int l = 1, r = len - 1;
        int ans = -1;
        while (l <= r) {
            // 数组中中间值
            int mid = (l + r) >> 1;
            // 用于记录数组中小于mid的数量
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            // 说明左半部分没有重复元素
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    // 3、快慢指针，时间复杂度为O(N)
    public int findDuplicate3(int[] nums) {
        int low = 0, fast = 0;
        do {
           low = nums[low];
           fast = nums[nums[fast]];
        } while (low != fast);
        low = 0;
        while (low != fast) {
            low = nums[low];
            fast = nums[fast];
        }
        return low;
    }

}
