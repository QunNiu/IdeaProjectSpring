package cn.edu.ctgu.title_1022.h4;

import java.util.Scanner;

/**
 * @author NiuQun
 * @date 2021/10/22
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ListNode next = null;

        for (int i = 7; i >= 1; i--) {
            ListNode newNode = new ListNode(i);
            newNode.next = next;
            next = newNode;
        }

        ListNode head = next;
        ListNode fast = head;
        ListNode slow = head;
        /*
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
        */

        for (int i = 1; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println(slow.data);
    }

}
class ListNode {
    int data;
    ListNode next = null;
    public ListNode(int data) {
        this.data = data;
    }
}
