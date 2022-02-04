package tree;


/**
 * @ClassName findTilt
 * @description:
 * 给定一个二叉树，计算 整个树 的坡度 。
 * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
 * 整个树 的坡度就是其所有节点的坡度之和。
 *
 * 输入：root = [4,2,9,3,5,null,7]
 * 输出：15
 * 解释：
 * 节点 3 的坡度：|0-0| = 0（没有子节点）
 * 节点 5 的坡度：|0-0| = 0（没有子节点）
 * 节点 7 的坡度：|0-0| = 0（没有子节点）
 * 节点 2 的坡度：|3-5| = 2（左子树就是左子节点，所以和是 3 ；右子树就是右子节点，所以和是 5 ）
 * 节点 9 的坡度：|0-7| = 7（没有左子树，所以和是 0 ；右子树正好是右子节点，所以和是 7 ）
 * 节点 4 的坡度：|(3+5+2)-(9+7)| = |10-16| = 6（左子树值为 3、5 和 2 ，和是 10 ；右子树值为 9 和 7 ，和是 16 ）
 * 坡度总和：0 + 0 + 0 + 2 + 7 + 6 = 15
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-11-18 19:34
 * @Version 1.0
 **/
public class findTilt {

    // 两层递归，效率低下
    public int findTilt1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.abs(getTreeSum(root.left) - getTreeSum(root.right)) + findTilt1(root.left) + findTilt1(root.right);
    }
    private int getTreeSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return  node.val + getTreeSum(node.left) + getTreeSum(node.right);

    }

    // 深度优先遍历
    int ans = 0;
    public int findTilt2(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sumLeft = dfs(node.left);
        int sumRight = dfs(node.right);
        ans += Math.abs(sumLeft - sumRight);
        return node.val + sumLeft + sumRight;
    }

}
