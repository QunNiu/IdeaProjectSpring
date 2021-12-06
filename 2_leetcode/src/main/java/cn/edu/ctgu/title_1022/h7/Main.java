package cn.edu.ctgu.title_1022.h7;

import java.util.*;

/**
 * @author NiuQun
 * @date 2021/10/23
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        ListNode next = null;

        Queue queue = new LinkedList<ListNode>();

        for (int i = arr.length - 1; i >= 0; i--) {
            ListNode newNode = new ListNode(arr[i]);
            // 在创建新的结点后，我们把该结点接入链表的同时也将其加入队列中
            queue.offer(newNode);
            newNode.next = next;
            next = newNode;
        }
        // 此时我们得到的链表的头结点
        ListNode head = next;


        // current指向链表中正在遍历的结点
        // temp指向当下从队列中取出的结点
        ListNode current = head;
        ListNode temp = null;
        // 根据队列的先进先出的特点，那么我们会从队列中倒着取出链表中的结点
        // 当取出的结点 与 遍历的链表中当下结点相同时，则结束

        while (current != queue.peek()) {
            // 临时保存链表中当前结点的下一个结点
            next = current.next;
            temp = (ListNode) queue.poll();

            current.next = temp;
            // 主要针对链表中结点时偶数的情况，不加判断会有重复
            if (next == temp) {
                // 偶数情况
                // 注意这里一定要把新链表的最后一个结点的next指针赋值为null，否则会出现循环链表的情况
                temp.next = null;
                break;
            }
            temp.next = next;
            current = next;
            // 奇数情况
            // 注意这里一定要把新链表的最后一个结点的next指针赋值为null，否则会出现循环链表的情况
            if (current == queue.peek()) {
                current.next = null;
                break;
            }
        }

        temp = head;
        while (temp != null) {
            if (temp.next != null) {
                System.out.print(temp.value + ",");
            } else {
                System.out.print(temp.value);
            }
            temp = temp.next;
        }

    }
}

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }
}

