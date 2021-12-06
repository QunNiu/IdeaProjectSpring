package cn.edu.ctgu.title_1105.h2_2;

/**
 * @author NiuQun
 * @date 2021/11/5
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode current = head;

        int flag = 0;
        int value = 0;
        while (l1 != null || l2 != null) {
            // 取出两个节点的值相加
            int x = (l1 == null) ? 0:l1.val;
            int y = (l2 == null) ? 0:l2.val;

            // 如果相加后值 >= 10，则表示需要进位
            int sum = x + y + flag;
            value = sum % 10;
            flag = sum / 10;
            current.next = new ListNode(value);
            current = current.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (flag == 1) {
            current.next = new ListNode(1);
        }
        return head.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
