package cn.edu.ctgu.title_1107.h6_206;

import java.util.Stack;

/**
 * @author NiuQun
 * @date 2021/11/7
 */
public class Solution {
    /**
     * 1.用栈实现链表反转
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        head = new ListNode();
        current = head;
        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }
        return head.next;
    }

    /**
     * 2.直接倒置结点法
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode next = head.next;
        while (current != null) {
            next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }
        return prev;
    }

    /**
     * 迭代法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}