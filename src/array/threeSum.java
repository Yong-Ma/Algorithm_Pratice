package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName threeSum
 * @description:
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-11-22 23:14
 * @Version 1.0
 **/
public class threeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len <= 2) {
            return res;
        }
        Arrays.sort(nums);
        for (int first = 0; first < len - 2; first++) {
            // 第一个数大于 0，后面的数都比它大，肯定不成立了
            if (nums[first] > 0) {
                break;
            }
            // 去掉重复情况
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int target = -nums[first];
            int left = first + 1, rigth = len - 1;
            while (left < rigth) {
                if (nums[left] + nums[rigth] == target) {
                    res.add(Arrays.asList( nums[first], nums[left], nums[rigth] ) );
                    // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1, right = 6, [-2, -1, 3] 的答案加入后，
                    // 需要排除重复的 -1 和 3
                    left++;
                    rigth--;
                    while (left < rigth && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < rigth && nums[rigth] == nums[rigth + 1]) {
                        rigth--;
                    }
                } else if(nums[left] + nums[rigth] < target) {
                    left++;
                } else {
                    rigth--;
                }
            }
        }
        return res;
    }
}
