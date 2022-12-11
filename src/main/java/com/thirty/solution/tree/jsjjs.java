package com.thirty.solution.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author ：yanpeidong371
 * @description：
 * @date : 2019年06月22日
 * @since: 1.0.0
 */
public class jsjjs {
    public static void main(String[] args){
       int [] arr = new int[]{9,5,2,3,6,7};
        jsjjs.quickSort(arr,0,5);
        System.out.println(arr[0]);
        System.out.println(arr[1]);System.out.println(arr[2]);System.out.println(arr[3]);System.out.println(arr[4]);
    }

    public static void quickSort(int[] arr,int start,int end){
        int i = start;
        int j = end;
        int pivot = arr[(i + j) /2]; //支点是数组中的一个值
        while(i <= j){ //i和j这2个指针只要没重叠（交换左右位置），就执行循环
            while(arr[i] < pivot){ //一直右移找到大于支点值得索引i
                i++;
            }
            while(arr[j] > pivot){//一直坐移找到小于支点值得索引j
                j--;
            }
            if(i<=j){ //找到上面说的2个索引，就替换他们的位置，这里判断i<=j才操作
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] =temp;
                i++; //交换完后继续移动
                j--; //交换完后继续移动，在判断
            }
        }
        //执行到这里，第一次循环完成，可以保证支点索引位置的左边的所有元素比支点索引右面的元素小
        if(start < j){
            quickSort(arr,start,j);
        }
        if(end > i){
            quickSort(arr,i,end);
        }

    }


    public LinkedList mergeTwoLists(LinkedList l1, LinkedList l2){
        LinkedList list = new LinkedList<Integer>();
        list.getFirst();
        return null;
    }

//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//
//        ListNode dummy = new ListNode(-1);
//
//        ListNode curNode = dummy;
//
//        while (l1 != null && l2 != null) {
//            if (l1.val <= l2.val) {
//                curNode.next = l1;
//                l1 = l1.next;
//            } else {
//                curNode.next = l2;
//                l2 = l2.next;
//            }
//            curNode = curNode.next;
//        }
//
//        curNode.next = (l1 != null) ? l1 : l2;
//
//        return dummy.next;
//    }


    /**
     * 顺序打印二叉树
     * @param root TreeNode类
     * @return int整型ArrayList<arraylist><>>
     */
//    public ArrayList levelOrder (TreeNode root) {
//        // write code here
//        ArrayList res = new ArrayList<>();//创建一个链表，用于存储
//        if(root == null )
//            return res;
//        LinkedList que = new LinkedList<>();
//        que.offer(root);//用来插入指定的元素插入此优先级队列
//        while(!que.isEmpty()){
//            int len = que.size();
//            ArrayList list = new ArrayList<>();
//            while(len > 0){
//                TreeNode node = que.poll();//poll是队列数据结构实现类的方法，从队首获取元素，同时获取的这个元素将从原队列删除；
//                list.add(node.val);
//                if(node.left != null)
//                    que.offer(node.left);
//                if(node.right != null)
//                    que.offer(node.right);
//                len--;
//            }
//            res.add(list);
//        }
//        return res;
//    }

}
