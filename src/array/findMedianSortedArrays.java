package array;

import java.util.Arrays;

/**
 * @ClassName findMedianSortedArrays
 * @description:
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 *
 * 示例 4：
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 *
 * 示例 5：
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-12-18 17:11
 * @Version 1.0
 **/
public class findMedianSortedArrays {

    //
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0 && len2 == 0) {
            return 0;
        } else if (len1 == 0) {
            if (len2 % 2 == 0) {
                return (double) (nums2[len2 / 2] + nums2[len2 / 2 - 1]) / 2;
            } else {
                return nums2[len2 / 2];
            }
        } else if (len2 == 0) {
            if (len1 % 2 == 0) {
                return (double) (nums1[len1 / 2] + nums1[len1 / 2 - 1]) / 2;
            } else {
                return nums1[len1 / 2];
            }
        }
        int[] newArr = Arrays.copyOf(nums1, len1 + len2);
        for (int i = len1; i < len1 + len2; i++) {
            newArr[i] = nums2[i - len1];
        }
        Arrays.sort(newArr);
        if ((len1 + len2) % 2 == 0) {
            return (double) (newArr[ (len1 + len2) / 2] + newArr[ (len1 + len2) / 2 - 1] ) / 2;
        } else {
            return newArr[ (len1 + len2) / 2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3}, nums2 = {2};
        findMedianSortedArrays(nums1, nums2);
    }
}
