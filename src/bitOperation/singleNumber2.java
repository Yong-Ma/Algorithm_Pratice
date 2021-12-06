package bitOperation;

import java.util.Arrays;

/**
 * @ClassName singleNumber2
 * @description:
 * 给你一个整数数组nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 *
 * 示例 2：
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-12-06 23:38
 * @Version 1.0
 **/
public class singleNumber2 {

    // 排序比较
    public int singleNumber1(int[] nums) {
        Arrays.sort(nums);
        int pre = nums[0], count = 1, res = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                count++;
            } else {
                if (count != 3) {
                    res = pre;
                    break;
                }
                pre = nums[i];
                count = 1;
            }
        }
        return res;
    }
    // 依次确定每一个二进制位
    public int singleNumber2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int a : nums) {
                total += (a >> i) & 1;
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

}
