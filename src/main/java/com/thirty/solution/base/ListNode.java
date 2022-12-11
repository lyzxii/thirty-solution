package com.thirty.solution.base;

/**
 * @author ：yanpeidong371
 * @description：
 * @date : 2022年11月11日
 * @since: 1.0.0
 */
public class ListNode {
    public int val;
    public com.algo.it.thirty.base.ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int[] nums) {
        com.algo.it.thirty.base.ListNode target = new com.algo.it.thirty.base.ListNode(nums[0]);
        com.algo.it.thirty.base.ListNode head = target;
        for (int i = 1; i < nums.length; i++) {
            target.next = new com.algo.it.thirty.base.ListNode(nums[i]);
            target = target.next;
        }
        this.val = head.val;
        this.next = head.next;
    }

    //打印链表结构
    public void printList() {
        com.algo.it.thirty.base.ListNode printhead = this;
        while (printhead != null) {
            System.out.print(printhead.val + "->");
            printhead = printhead.next;
        }
        System.out.println();
    }
}
