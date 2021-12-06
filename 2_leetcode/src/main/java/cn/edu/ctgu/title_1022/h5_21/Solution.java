package cn.edu.ctgu.title_1022.h5_21;

/**
 * 合并两个有序链表
 * @author NiuQun
 * @date 2021/10/22
 */

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 如果其中一个链表为空，则直接返回另一个链表的头结点
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // head为合并后的新链表的头结点
        ListNode head;

        // 通过两个链表的第一个结点的值比较，值小的为头结点
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        // 用end指向合并后新链表的最后一个结点
        ListNode end = head;

        // 注意核心思想是：将新链表的最后一个结点连到l1 和 l2中较小的那一个结点，
        // 因为可能出现并不是交叉连接的现象
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                end.next = l1;
                l1 = l1.next;
            } else {
                end.next = l2;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            end.next = l2;
        }

        if (l2 == null) {
            end.next = l1;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }