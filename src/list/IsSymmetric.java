package list;

import dfs.TreeNode;

import java.time.temporal.Temporal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName IsSymmetric
 * @description:
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2022-01-02 16:53
 * @Version 1.0
 **/
public class IsSymmetric {

    // 迭代法
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            ArrayList<Integer> sameLayerTreeNodeList = new ArrayList<>();
            while (size > 0) {
                TreeNode treeNode = deque.pollFirst();
                TreeNode left = treeNode.left;
                TreeNode right = treeNode.right;
                if (left != null) {
                    sameLayerTreeNodeList.add(treeNode.left.val);
                    deque.addLast(left);
                } else {
                    sameLayerTreeNodeList.add(9999);
                }
                if (right != null) {
                    sameLayerTreeNodeList.add(treeNode.right.val);
                    deque.addLast(right);
                } else {
                    sameLayerTreeNodeList.add(9999);
                }
                size--;
            }
            int l = 0, r = sameLayerTreeNodeList.size() - 1;
            while (l < r) {
                if (!sameLayerTreeNodeList.get(l).equals(sameLayerTreeNodeList.get(r))) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }

    // 递归
    public boolean isSymmetric2(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }


}
