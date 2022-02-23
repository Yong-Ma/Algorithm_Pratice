package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName minimumTotal
 * @description:
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 示例 1：
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-10-19 22:15
 * @Version 1.0
 **/
public class minimumTotal {

    // 动态规划做法
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            // 每行第一个值
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            // 每行最后一个值
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;

    }
    // 不用数组的做法
    public static int minimumTotal2(List<List<Integer>> triangle) {

        ArrayList<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(triangle.get(0).get(0));
        list.add(list1);

        for (int i = 1; i < triangle.size(); ++i) {
            ArrayList<Integer> tmpList = new ArrayList<>();
            list.add(tmpList);
            list.get(i).add(list.get(i -1).get(0) + triangle.get(i).get(0));
            for (int j = 1; j < i; ++j) {
                list.get(i).add(Math.min(list.get(i - 1).get(j - 1),list.get(i - 1).get(j)) + triangle.get(i).get(j));
            }
            list.get(i).add(list.get(i -1).get(i - 1) + triangle.get(i).get(i));
        }
        return list.get(list.size() - 1).stream().min(Comparator.comparingInt(a -> a)).orElse(0);
    }

    // 测试
    public static void main(String[] args) {
        ArrayList<List<Integer>> triangle = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(-1);
        triangle.add(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(-2);
        list2.add(-3);
        triangle.add(list2);
        minimumTotal2(triangle);
    }
}
