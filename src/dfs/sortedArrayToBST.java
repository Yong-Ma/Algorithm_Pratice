package dfs;

/**
 * @ClassName sortedArrayToBST
 * @description:
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * 示例 1：
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 *
 * 示例 2：
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
 *
 * 提示：
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 按 严格递增 顺序排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-12-12 18:43
 * @Version 1.0
 **/
public class sortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int l = 0, r = nums.length - 1;
        return dfs(l, r, nums);
    }

    private TreeNode dfs(int l, int r, int[] nums) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(l, mid - 1, nums);
        node.right = dfs(mid + 1, r, nums);
        return node;
    }
}
