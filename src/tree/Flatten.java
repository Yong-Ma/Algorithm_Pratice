package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Flatten
 * @description:
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * 示例 1：
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [0]
 * 输出：[0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2022-01-25 00:09
 * @Version 1.0
 **/
public class Flatten {

    // 前序遍历，递归
    public void flatten1(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        recallTree(list, root);
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1), cur = list.get(i);
            prev.left = null;
            prev.right = cur;
        }
    }
    private void recallTree(List<TreeNode> list, TreeNode node) {
        if (node != null) {
            list.add(node);
            recallTree(list, node.left);
            recallTree(list, node.right);
        }
    }

    // 前序遍历，迭代
    public void flatten2(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                list.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1), cur = list.get(i);
            prev.left = null;
            prev.right = cur;
        }
    }

    // 3、寻找前驱节点
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }

}
