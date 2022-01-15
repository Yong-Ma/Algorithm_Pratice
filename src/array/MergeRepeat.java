package array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName MergeRepeat
 * @description:
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2022-01-15 18:18
 * @Version 1.0
 **/
public class MergeRepeat {

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) {
            return new int[][]{};
        }
        // 根据每个范围的左边进行排序
        Arrays.sort(intervals, (int[]a ,int[] b) ->{ return a[0] - b[0]; });
        ArrayList<int[]> ret = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            if (ret.size() == 0 || ret.get(ret.size() - 1)[1] < L) {
                ret.add(new int[]{L, R});
            } else {
                ret.get(ret.size() - 1)[1] = Math.max(ret.get(ret.size() - 1)[1], R);
            }
        }
        return ret.toArray(new int[ret.size()][0]);
    }
}
