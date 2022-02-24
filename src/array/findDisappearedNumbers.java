package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName findDisappearedNumbers
 * @description:
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 * 示例 1：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 *
 * 示例 2：
 * 输入：nums = [1,1]
 * 输出：[2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2022-01-06 23:44
 * @Version 1.0
 **/
public class findDisappearedNumbers {

    // 原地修改
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> ret = new ArrayList<>();
        int len = nums.length;
        for (int num : nums) {
            // 该数如果在数组中排序，应放置在数组的位置
            int position = (num - 1) % len;
            nums[position] += len;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] <= len) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}
