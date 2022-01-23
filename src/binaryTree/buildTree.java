package binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName buildTree
 * @description:
 * 给定一棵树的前序遍历preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。
 *
 * 示例 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * 示例 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2022-01-23 15:20
 * @Version 1.0
 **/
public class buildTree {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        } else if (preorder.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[0]);
        // 根在中序遍历中的位置
        int headPos = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (head.val == inorder[i]) {
                headPos = i;
                break;
            }
        }
        // 中序遍历的左右子树序列
        int[] inLeftTree = Arrays.copyOfRange(inorder, 0, headPos);
        int[] inRightTree = Arrays.copyOfRange(inorder, headPos + 1, inorder.length);


        int preLeftTreeRigthIndex = 1;
        List<Integer> inLeftTreeList = Arrays.stream(inLeftTree).boxed().collect(Collectors.toList());
        while (preLeftTreeRigthIndex < preorder.length && inLeftTreeList.contains(preorder[preLeftTreeRigthIndex]) ) {
            preLeftTreeRigthIndex++;
        }

        // 前序序遍历的左右子树序列
        int[] preLeftTree = Arrays.copyOfRange(preorder, 1, preLeftTreeRigthIndex);
        int[] preRightTree = Arrays.copyOfRange(preorder, preLeftTreeRigthIndex, preorder.length);

        head.left = buildTree(preLeftTree, inLeftTree);
        head.right = buildTree(preRightTree, inRightTree);
        return head;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2},  inorder = {1, 2};
        buildTree(preorder, inorder);
    }

    // 第二种更优雅的方法
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}
