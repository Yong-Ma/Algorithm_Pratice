package bitOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName subsets
 * @description:
 * 给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-12-04 23:20
 * @Version 1.0
 **/
public class subsets {

    // 使用位运算方法
    public List<List<Integer>> subsets1(int[] nums) {

        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int mask = 0; mask < (1 << len); mask++) {
            list.clear();
            for (int i = 0; i < len; i++) {
                if ( (mask & (1 << i) ) != 0) {
                    list.add(nums[i]);
                }
            }
            res.add(new ArrayList<>(list));
        }
        return res;

    }

    // 递归回溯
    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets2(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        // 加入
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        // 回溯
        t.remove(t.size() - 1);
        // 不加入
        dfs(cur + 1, nums);
    }
}
