package binarySearch;

/**
 * @ClassName searchRange
 * @description:
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 进阶：
 * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
 *
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 示例2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-11-13 22:04
 * @Version 1.0
 **/
public class searchRange {

    // 二分查找
    public int[] searchRange(int[] nums, int target) {

        int len = nums.length;
        int l = 0, r = len - 1;
        int start = -1 ,end = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                start = mid;
                end = mid;
                for (int i = mid + 1; i < len; i++) {
                    if (nums[i] == target) {
                        end++;
                    } else {
                        break;
                    }
                }
                for (int i = mid -1; i >= 0; i--) {
                    if (nums[i] == target) {
                        start--;
                    }else {
                        break;
                    }
                }
                return new int[]{start, end};
            }
            if (nums[mid] > target) {
                r = mid -1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        return new int[]{start, end};
    }
}
