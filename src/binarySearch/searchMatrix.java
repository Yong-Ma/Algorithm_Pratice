package binarySearch;

import java.util.Arrays;

/**
 * @ClassName searchMatrix
 * @description:
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-11-15 23:15
 * @Version 1.0
 **/
public class searchMatrix {

    // 两次2分查找，时间复杂度为O（log(n+m)）
    public boolean searchMatrix(int[][] matrix, int target) {

        int l = 0, r = matrix.length - 1;
        if (r == 0) {
            return Arrays.binarySearch(matrix[0], target) >= 0;
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (r == -1) {
            r = 0;
        }
        return Arrays.binarySearch(matrix[r], target) >= 0;
    }
}
