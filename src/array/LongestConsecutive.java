package array;

import java.util.HashSet;

/**
 * @ClassName longestConsecutive
 * @description:
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2022-01-26 23:10
 * @Version 1.0
 **/
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        // 1、对原数组进行去重
        for (int a : nums) {
            set.add(a);
        }
        int longestLen = 1;
        for (int a : nums) {
            // 该数没前驱，可作为连续序列的起点
            if (!set.contains(a - 1)) {
                int curLen = 1;
                while (set.contains(++a)) {
                    curLen++;
                }
                longestLen = Math.max(longestLen, curLen);
            }
        }
        return longestLen;
    }
}
