package cn.edu.ctgu.algorithm;

import java.util.List;

/**
 * @author NiuQun
 * @date 2021/10/17
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = node1;

        /*
        iteratorList(head);
        ListNode reverseHead = reverseList(head);

        iteratorList(reverseHead);

        // 测试只有1个结点的情况
        ListNode node = new ListNode(10, null);
        iteratorList(node);
        ListNode reverseNode = reverseList(node);
        iteratorList(reverseNode);

         */
        // 测试递归方法反转链表
        iteratorList(head);
        ListNode recursionHead = reverseListByRecursion(head);
        iteratorList(recursionHead);
    }

    public static ListNode reverseList(ListNode head) {
        // 如果没有结点或者只有1个结点，直接返回head即可
        if (head == null) {
            return null;
        }

        // current指向当前需要将next指针指向前一个结点的结点
        ListNode current = head;
        // 临时保存current结点的左边一个结点
        ListNode prev = null;
        // 临时保存current结点的右边一个结点
        ListNode next = null;


        // 遍历链表，修改next指针
        while (current != null) {
            // 将current结点的next指针指向左边的结点之前，需要临时记录current右边的结点，否则后边就找不到了
            next = current.next;

            // 将current结点指向左边的一个结点
            current.next = prev;

            prev = current;
            current = next;
        }
        // 此时prev指向链表的最后一个结点
        return prev;
    }

    public static ListNode reverseListTest(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static ListNode reverseListByRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;


    }

    public static ListNode reverseListByRecursionTest(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListByRecursionTest(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    /**
     * 遍历链表
     */
    public static void iteratorList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("+++++++++++++++++");
    }


}
class ListNode {
    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    int data;
    ListNode next;

}