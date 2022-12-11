package com.thirty.solution.tree;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author ：yanpeidong371
 * @description：
 * @date : 2021年11月06日
 * @since: 1.0.0
 */
public class TreeTest {



    static class Node{
        int value;
        Node left;
        Node right;

        public Node right(){ return right;}

        public Node left(){ return left;}

        public Node(int value, Node left, Node right){
            this.right = right;
            this.left = left;
            this.value = value;
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Node node1 = new Node(2, null, null);
        Node node2 = new Node(5, null, null);
        Node node3 = new Node(6, node1, node2);

        Node node4 = new Node(3, null, null);
        Node node5 = new Node(7, node3, node4);

        Node node6 = new Node(8, null, null);
        Node node7 = new Node(9, null, null);

        Node node8 = new Node(10, node6, node7);
        Node root = new Node(1, node5, node8);
        LinkedList queue = new LinkedList<Node>();



        sort(root, queue);
        System.out.println("=====");
        //priorOrderNonRecursive(root, queue);

    }

    public static void sort(Node root,LinkedList queue) throws InterruptedException {

        queue.addFirst(root);
        while (!queue.isEmpty()){

            Node node = (Node)queue.removeFirst();
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

    public static void midSort(Node root,LinkedList queue) {
        Node p = root;
        while (p != null || !queue.isEmpty()) {
            while(p!=null){
                queue.addFirst(p);
                p = p.left;
            }
            if(!queue.isEmpty()){
                Node node = (Node) queue.removeFirst();
                System.out.println(node.value);
                p = node.right;
            }
        }

    }


}
