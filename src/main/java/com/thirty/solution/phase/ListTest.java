package com.thirty.solution.phase;

import com.thirty.solution.base.ListNode;

/**
 * @author ：yanpeidong
 * @description：链表算法
 * @date : 2022年12月17日
 * @since: 1.0.0
 */
public class ListTest {

    /**
     * 合并2个列表
     */
    public static ListNode mergeListNode(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (l1 != null & l2 != null) {
            if (l1.val > l2.val) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    /**
     * 合并2个列表
     */
    public static ListNode mergeListNode02(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeListNode02(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeListNode02(l1, l2.next);
            return l2;
        }
    }


    /**
     * 单链表的分解,使得小于x的节点都出现在大于等于x节点之前
     */
    public static ListNode splitListNode(ListNode listNode, int x) {
        ListNode dummy01 = new ListNode(-1);
        ListNode p1 = dummy01;
        ListNode dummy02 = new ListNode(-1);
        ListNode p2 = dummy02;
        ListNode head = listNode;
        while (head != null) {
            if (x > head.val) {
                p2.next = head;
                p2 = p2.next;
            } else {
                p1.next = head;
                p1 = p1.next;
            }
            ListNode next = head.next;
            head.next = null;
            head = next;
        }
        p2.next = dummy01.next;
        return dummy02.next;
    }


    /**
     * 单链表的倒数第 k 个节点
     * <p>
     * 思路：双指针，p1指针走k步，离终点还剩下n-k步时，初始化指针p2，和p1指针一起移动，
     * 开始移动n-k步后，p1到底终点，p2走了n-k,离终点k个节点
     */
    public static ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        //p1 先走k步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    /**
     * 删除链表倒数第k个节点
     *
     * 思路：找到倒数第k+1个节点，然后将k+1的节点next指向next的next
     */
    public static ListNode deleteFromEnd(ListNode head, int k){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = ListTest.findFromEnd(head, k + 1);
        node.next = node.next.next;
        return dummy.next;
    }


    /**
     * 获取链表的中间节点
     * 思路：使用快慢指针解决
     * 慢指针移动一步，快指针移动2步，快指针到底，慢指针则到达终点
     */
    public static ListNode midListNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast !=null && (fast =fast.next) != null){
            fast =fast.next;
            slow =slow.next;
        }
        return slow;
    }

    /**
     * 判断链表是否包含环
     * 思路：使用快慢指针解决，快指针最后为null则不是环，快慢指针相遇则是环
     */
    public static boolean isCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast !=null && (fast =fast.next) != null){
            fast =fast.next;
            slow =slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    /**
     * 链表相交
     * 给你输入两个链表的头结点 headA 和 headB，如果相交，你的算法应该返回相交的那个节点;
     * 如果没相交，则返回 null。
     * A1-A2-B1-B2-C1-C2-C3-B1
     * C1-C2-C3-B1-B2-A1-A2-B1
     *
     */
    public static ListNode getIntersectionNode(ListNode nodeA, ListNode nodeB){
        ListNode p1 =nodeA, p2=nodeB;
        while(p1 != p2){
            if(p1==null){
                p1 =nodeB;
            }else{
                p1=p1.next;
            }

            if(p2==null){
                p2 =nodeA;
            }else{
                p2=p2.next;
            }
        }
        return p1;
    }


    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        // 计算两条链表的长度
        for (ListNode p1 = headA; p1 != null; p1 = p1.next) {
            lenA++;
        }
        for (ListNode p2 = headB; p2 != null; p2 = p2.next) {
            lenB++;
        }
        // 让 p1 和 p2 到达尾部的距离相同
        ListNode p1 = headA, p2 = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                p2 = p2.next;
            }
        }
        // 看两个指针是否会相同，p1 == p2 时有两种情况：
        // 1、要么是两条链表不相交，他俩同时走到尾部空指针
        // 2、要么是两条链表相交，他俩走到两条链表的相交点
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(new int[]{1, 3, 4, 6, 9});
        ListNode two = new ListNode(new int[]{2, 5, 7, 8, 10});

        //mergeListNode02(one, two).printList();


        ListNode listNode = new ListNode(new int[]{1, 4, 3, 2, 1, 9, 5, 2, 2});

        ListNode listNode1 = splitListNode(listNode, 3);
        listNode1.printList();
        ListNode head = new ListNode(new int[]{1,2, 5, 7, 8, 10,2,5});
        System.out.println(ListTest.findFromEnd(head, 3));

        ListNode listNode2 = ListTest.midListNode(head);
        System.out.println(listNode2.val);


        ListNode nodeA = new ListNode(new int[]{ 1});
        ListNode nodeC = new ListNode(new int[]{ 5});
        ListNode nodeB = new ListNode(new int[]{ 2});

        ListNode node = new ListNode(new int[]{ 6, 9});
        nodeA.next =nodeC;
        nodeC.next=node;
        nodeB.next=node;


        //ListNode intersectionNode = ListTest.getIntersectionNode(nodeA, nodeB);
        ListNode intersectionNode2 = ListTest.getIntersectionNode2(nodeA, nodeB);
        System.out.println(intersectionNode2.val);
    }

}
