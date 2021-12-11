package com.thirty.solution.tree;

/**
 * @author ：yanpeidong
 * @description：
 * @date : 2021年12月11日
 * @since: 1.0.0
 */

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
