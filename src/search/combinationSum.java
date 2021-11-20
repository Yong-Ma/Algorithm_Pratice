package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName combinationSum
 * @description:
 * 给定一个无重复元素的正整数数组candidates和一个正整数target，找出candidates中所有可以使数字和为目标数target的唯一组合。
 * candidates中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 * 对于给定的输入，保证和为target 的唯一组合数少于 150 个。
 *
 * 示例1：
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 *
 * 示例2：
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * 示例 3：
 * 输入: candidates = [2], target = 1
 * 输出: []
 *
 * 示例 4：
 * 输入: candidates = [1], target = 1
 * 输出: [[1]]
 *
 * 示例 5：
 * 输入: candidates = [1], target = 2
 * 输出: [[1,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-11-20 21:02
 * @Version 1.0
 **/
public class combinationSum {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return res;
    }
    private void dfs(int[] arr, int target,int idx) {
        if (idx == arr.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }
        // 直接跳过
        dfs(arr, target, idx + 1);
        if (target - arr[idx] >=0) {
            ans.add(arr[idx]);
            dfs(arr, target - arr[idx], idx);
            ans.remove(ans.size() - 1);
        }
    }
}
