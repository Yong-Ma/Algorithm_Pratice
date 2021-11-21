package binaryTree;

/**
 * @ClassName TreeNode
 * @description:
 * Definition for a binary tree node.
 * @author: mzy
 * @create: 2021-11-18 19:40
 * @Version 1.0
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
