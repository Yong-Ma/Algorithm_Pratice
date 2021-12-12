package dfs;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName maxDepth
 * @description:
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-12-12 17:56
 * @Version 1.0
 **/
public class maxDepth {

    // 深度优先算法
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left),  maxDepth(root.right)) + 1;
    }

    // 广度优先算法
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> quueu = new LinkedList<>();
        quueu.offer(root);
        int ans = 0;
        while (!quueu.isEmpty()) {
            int size = quueu.size();
            while (size > 0) {
                TreeNode node = quueu.poll();
                if (node.left != null) {
                    quueu.offer(node.left);
                }
                if (node.right != null) {
                    quueu.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
