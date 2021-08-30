package leetcode.other;

/**
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 * 子数组 定义为原数组中的一个连续子序列。
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 *
 * 示例 1：
 *
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.c1588. 所有奇数长度子数组的和om/problems/sum-of-all-odd-length-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yong
 * @date 2021/8/29 21:58
 */
public class sumOddLengthSubarrays {

    // 自己写的暴力解法
    public int sumOddLengthSubarrays1(int[] arr) {

        int sum = 0;
        for (int i = 1; i <= arr.length ; i+=2) {
            for (int j = 0; j < arr.length - i + 1; j++) {
                int tmp = 0;
                for (int k = j; k < j + i ; k++) {
                    tmp += arr[k];
                }
                sum += tmp;
            }
        }
        return sum;
    }
    // 官方解答的暴力方法
    public int sumOddLengthSubarrays2(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int start = 0; start < n; start++) {
            for (int length = 1; start + length <= n; length += 2) {
                int end = start + length - 1;
                for (int i = start; i <= end; i++) {
                    sum += arr[i];
                }
            }
        }
        return sum;
    }
    // 使用前缀和减少子数组求和，使时间复杂度从O（n^3）减少为O（n^2）
    public int sumOddLengthSubarrays3(int[] arr) {
        int sum = 0;
        int len = arr.length;
        int [] previousArr = new int [len + 1];
        for (int i = 0; i < len; i++) {
            previousArr[i + 1] = previousArr[i] + arr[i];
        }
        for (int start = 0; start < len; start++) {
            for (int length = 1; length + start <= len ; length+=2) {
                int end = start + length - 1;
                sum += (previousArr[end + 1] - previousArr[start] );
            }
        }
        return sum;
    }
}
