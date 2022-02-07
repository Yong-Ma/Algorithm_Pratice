package num;

/**
 * @ClassName ProductExceptSelf
 * @description:
 * 给你一个整数数组nums，返回 数组answer，其中answer[i]等于nums中除nums[i]之外其余各元素的乘积。
 * 题目数据 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。
 * 请不要使用除法，且在O(n) 时间复杂度内完成此题。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 示例 2:
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 *
 * 提示：
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2022-02-07 21:46
 * @Version 1.0
 **/
public class ProductExceptSelf {

    // 时间空间复杂度均为O(N)
    public int[] productExceptSelf1(int[] nums) {
        
        int len = nums.length;
        int[] preMulti = new int[len];
        int[] sufMulti = new int[len];
        int[] answers = new int[len];

        // 求前缀和
        preMulti[0] = 1;
        for (int i = 1; i < len; i++) {
            preMulti[i] = preMulti[i - 1] * nums[i - 1];
        }
        // 求后缀和
        sufMulti[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            sufMulti[i] = sufMulti[i + 1] * nums[i + 1];
        }
        // 前缀和与后缀和相乘得到
        for (int i = 0; i < len; i++) {
            answers[i] = preMulti[i] * sufMulti[i];
        }
        return answers;
    }

    // 时间复杂度为O(N), 空间复杂度为O(1)
    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] answers = new int[len];

        // 求前缀和
        answers[0] = 1;
        for (int i = 1; i < len; i++) {
            answers[i] = answers[i - 1] * nums[i - 1];
        }
        // 代表当前的后缀和
        int R = 1;
        // 计算结果
        for (int i = len - 2; i >= 0; i--) {
            R *= nums[i + 1];
            answers[i] *= R;
        }
        return answers;
    }
}
