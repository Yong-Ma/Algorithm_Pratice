package binarySearch;

/**
 * @ClassName searchInsert
 * @description:
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 示例2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-11-14 23:31
 * @Version 1.0
 **/
public class searchInsert {

//    复杂度分析
//    时间复杂度：O(log n)，其中 nn 为数组的长度。二分查找所需的时间复杂度为O(logn)。
//    空间复杂度：O(1)。我们只需要常数空间存放若干变量

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1,ans  = len;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
