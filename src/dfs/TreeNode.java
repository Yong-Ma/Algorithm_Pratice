package dfs;

/**
 * @Description:
 * Definition for a binary tree node.
 * @Author: mzy
 * @Date: 2021/12/12 17:57
 **/
public class TreeNode {
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