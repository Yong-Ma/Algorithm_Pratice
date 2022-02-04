package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName inorderTraversal
 * @description: 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[2,1]
 * <p>
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * <p>
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-12-15 22:29
 * @Version 1.0
 **/
public class inorderTraversal {

    // 递归
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            helper(node.left, res);
        }
        res.add(node.val);
        if (node.right != null) {
            helper(node.right, res);
        }
    }

    // 迭代
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.poll();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}

