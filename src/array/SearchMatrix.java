package array;

import java.util.Arrays;

/**
 * @ClassName SearchMatrix
 * @description:
 * 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 示例 1：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 *
 * 示例 2：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109<= matrix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109<= target <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2022-02-08 23:31
 * @Version 1.0
 **/
public class SearchMatrix {

    // 1、暴力解法，时间复杂度为O(N * M)
    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // 2、二分查找法，时间复杂度为O(M * log N)
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            int index = binarySearch(matrix[i], target);
            // int index = Arrays.binarySearch(matrix[i], target);
            if (index != -1) {
                return true;
            }
        }
        return false;
    }

    // 二分查找
    private int binarySearch(int[] matrix, int target) {
        int low = 0, height = matrix.length - 1;
        while (low <= height) {
            int mid = (height - low) / 2 + low;
            // int mid = (low + height) >> 1;
            if (matrix[mid] == target) {
                return mid;
            } else if (matrix[mid] > target) {
                height = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // 3、Z字形查找,时间复杂度为O(N + M)
    public boolean searchMatrix3(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }

}
