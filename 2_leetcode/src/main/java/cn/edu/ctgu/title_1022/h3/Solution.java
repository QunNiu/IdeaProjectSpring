package cn.edu.ctgu.title_1022.h3;

/**
 * 反转链表
 * @author NiuQun
 * @date 2021/10/22
 */
public class Solution {
    public static void main(String[] args) {

    }


    /**
     * 1.直接倒置结点法
     */
    /*
    public ListNode ReverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    */

    /**
     * 2.迭代法
     *
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}