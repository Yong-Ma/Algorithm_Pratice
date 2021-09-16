package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName generateYanghuiTriangle
 * @description:
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 示例 1:
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例2:
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-09-16 21:43
 * @Version 1.0
 **/
public class generateYanghuiTriangle {

    // 自己写的，有点繁琐，不够优雅
    public List<List<Integer>> generate1(int numRows) {
        // 1、初始化数组，数组初始值为 1
        int[][] dp = new int[numRows][];
        for (int i = 0; i < numRows; i++) {
            int[] arr = new int[i + 1];
            Arrays.fill(arr,1);
            dp[i] = arr;
        }
        // 2、动态规划
        for (int i = 2; i < numRows; i++) {
            for (int j = 1; j < i ; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i -1][j];
            }
        }
        // 3、数组转化为List<List<Integer>>返回
        return Arrays.stream(dp).map(ints -> {
              return Arrays.stream(ints).boxed().collect(Collectors.toList());
//            ArrayList<Integer> list = new ArrayList<>();
//            for (int a : ints) {
//                list.add(a);
//            }
//            return list;
        }).collect(Collectors.toList());
    }

    // 优雅的做法
    public List<List<Integer>> generate2(int numRows) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                }else {
                    list.add(res.get(i-1).get(j -1) + res.get(i-1).get(j));
                }
            }
            res.add(list);
        }
        return res;
    }
}
