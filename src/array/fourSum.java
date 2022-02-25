package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName fourSum
 * @description:
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d< n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * 示例 2：
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-11-23 17:41
 * @Version 1.0
 **/
public class fourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len <= 3) {
            return res;
        }
        // 进行排序
        Arrays.sort(nums);
        for (int a = 0; a < len - 3; a++) {
           if (a > 0 && nums[a] == nums[a - 1]) {
               continue;
           }
           for (int b = a + 1; b < len - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                int sum = target - nums[a] - nums[b];
                // 左右双指针=初始位置
                int left = b + 1, rigth = len - 1;
                while (left < rigth) {
                    if (sum == nums[left] + nums[rigth]) {
                        res.add(Arrays.asList(nums[a], nums[b], nums[left], nums[rigth]));
                        left++;
                        rigth--;
                        while (left < rigth && nums[left] == nums[left -1]) {
                            left++;
                        }
                        while (left < rigth && nums[rigth] == nums[rigth + 1]) {
                            rigth--;
                        }
                    } else if (sum > nums[left] + nums[rigth]) {
                        left++;
                    } else {
                        rigth--;
                    }
                }
           }
        }
        return res;
    }
}
