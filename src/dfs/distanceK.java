package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName distanceK
 * @description:
 * 给定一个二叉树（具有根结点root），一个目标结点target，和一个整数值 K 。
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 *
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 *
 * 提示：
 * 给定的树是非空的。
 * 树上的每个结点都具有唯一的值0 <= node.val <= 500。
 * 目标结点target是树上的结点。
 * 0 <= K <= 1000.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-12-21 21:03
 * @Version 1.0
 **/
public class distanceK {
    HashMap<Integer, TreeNode> parents = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParents(root);
        dfs(target, null, 0, k);
        return ans;
    }
    // 寻找所有节点的父节点
    private void findParents(TreeNode node) {
        if(node.left != null) {
            parents.put(node.left.val, node);
            findParents(node.left);
        }
        if(node.right != null) {
            parents.put(node.right.val, node);
            findParents(node.right);
        }
    }
    // dfs
    private void dfs(TreeNode node, TreeNode from , int deepth, int k) {
        if(node == null) {
            return ;
        }
        if(deepth == k) {
            ans.add(node.val);
            return ;
        }
        // 向下搜索,如果是向上搜索来的，为了避免重复，不要再向左节点或右节点下搜索
        if(node.left != from) {
            dfs(node.left, node, deepth + 1, k);
        }
        if(node.right != from) {
            dfs(node.right, node, deepth + 1, k);
        }
        // 向上搜索，如果是向下搜索来的，就不要向上了，防止重复
        if(parents.get(node.val) != from) {
            dfs(parents.get(node.val), node, deepth + 1, k);
        }
    }
}
