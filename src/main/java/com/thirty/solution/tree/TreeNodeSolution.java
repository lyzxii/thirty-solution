/*
package com.thirty.solution.tree;

import java.util.*;

*
 *
 *
 * @date : 2021年12月11日
 *       6
 *
 *


public class TreeNodeSolution {

    public static void main(String[] args) {

    }


*
     *       A
     *      / \
     *     B   C
     * 二叉树遍历， 主要分为：前序遍历，中序遍历，后序遍历，区别如下
     *  前序 ABC  根-左-右
     *  中序 BAC  左-根-右
     *  后序 BCA  左-右-根
     *
     *  主要遍历方式：1. 递归。所有二叉树都可以使用递归去做，递归需要有终止条件
     *              2. 利用栈的数据结构进行遍历





*
     * 递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)


    public static List<Integer> recTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res); //前序遍历
        return res;
    }

    public static void preOrder(TreeNode root, List<Integer> res) {
        if(root == null) return;
        res.add(root.val); //根
        preOrder(root.left, res);//左
        preOrder(root.right, res);//右
    }

****************************************************************************************************************


*
     * 前序遍历 非递归


    public static void preOrderTree(TreeNode root) {
        List<Integer> res = new ArrayList();
        Stack<TreeNode> stack = new Stack<>();
        //先序遍历是 根左右
        while (root != null || !stack.isEmpty()){
            res.add(root.val);
            if(root.right != null){
                root = root.right;
            }



            stack.add()
            while (!queue.isEmpty()){

                TreeTest.Node node = (TreeTest.Node)queue.removeFirst();
                if(node != null){
                    System.out.println(node.value);
                    if(node.right !=null){
                        queue.addFirst(node.right);
                    }

                    if(node.left !=null){
                        queue.addFirst(node.left);
                    }
                }else{
                    continue;
                }
            }

        }





    }


*
     *
     * 栈 先进后出
     * 前序遍历，出栈顺序：根左右; 入栈顺序：右左根
     * 中序遍历，出栈顺序：左根右; 入栈顺序：右根左
     * 后序遍历，出栈顺序：左右根; 入栈顺序：根右左


    public static List<Integer> midOrderTree(TreeNode root){
        List<Integer> res = new ArrayList();
        Stack<TreeNode> stack = new Stack<>();
        // root为空且stack为空，遍历结束，中序遍历是 左根右
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                // 先根后左入栈,将所有左节点压入栈中
                stack.push(root);
                root = root.left;
            }
            // 开始出栈,到这里说明所有左节点都加入栈了，开始遍历，弹出第一个元素，即最后一个左节点，这个左子节点没有左节点
            root = stack.pop();
            res.add(root.val);//添加
            root = root.right;//然后将取出右节点，循环
        }
        return res;
    }

*
     * 先序遍历


    public static void postSort(TreeNode root){


    }


}
*/
