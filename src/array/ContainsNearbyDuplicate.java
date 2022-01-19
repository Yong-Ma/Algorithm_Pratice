package array;

/**
 * @ClassName ContainsNearbyDuplicate
 * @description:
 * 给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个 不同的索引i和j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 *
 * 示例1：
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 *
 * 示例 2：
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 *
 * 示例 3：
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2022-01-19 23:00
 * @Version 1.0
 **/
public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k; j++) {
                if (j > nums.length - 1) {
                    break;
                }
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
