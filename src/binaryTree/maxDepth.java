package binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName maxDepth
 * @description:
 * 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 *
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-11-21 16:30
 * @Version 1.0
 **/
public class maxDepth {
    int maxDepth = 0;
    public int maxDepth(Node root) {
        if(root == null) {
            return maxDepth;
        }
        dfs(root, 1);
        return maxDepth;
    }
    private void dfs(Node node, int depth) {
        if (node.children.size() == 0) {
            maxDepth = Math.max(maxDepth, depth);
            return ;
        }
        for (Node children : node.children) {
            dfs(children, depth + 1);
        }
    }
    // 广度优先搜索
    public int maxDepth2(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node node = queue.poll();
                List<Node> children = node.children;
                for (Node child : children) {
                    queue.offer(child);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }

}
