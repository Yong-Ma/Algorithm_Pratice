package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName gerYanghuiTriangleRow
 * @description:
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 示例 1:
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 *
 * 示例 2:
 * 输入: rowIndex = 0
 * 输出: [1]
 *
 * 示例 3:
 * 输入: rowIndex = 1
 * 输出: [1,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-09-16 23:11
 * @Version 1.0
 **/
public class gerYanghuiTriangleRow {

    // 递推
    public List<Integer> getRow1(int rowIndex) {

        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            res.add(0);
            for (int j = i; j > 0 ; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return pre;
    }

}
