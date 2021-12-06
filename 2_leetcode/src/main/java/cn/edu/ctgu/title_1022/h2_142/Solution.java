package cn.edu.ctgu.title_1022.h2_142;

import java.util.HashSet;

/**
 * leetcode第142题
 * @author NiuQun
 * @date 2021/10/22
 */
public class Solution {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = null;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                // 用temp记录快慢指针交汇的结点
                temp = fast;
                break;
            }
        }
        // 说明链表无环
        if (temp == null) {
            return null;
        }

        //链表起点
        ListNode start = head;

        //从起点到入口点 == 从相遇点到入口点（当然，可能其中绕了n圈）
        while (start != temp) {
            start = start.next;
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 哈希表法：
     * 解题思路：
     * 我们遍历链表中的每个节点，并将它记录下来；一旦遇到了此前遍历过的节点，就可以判定链表中存在环。借助哈希表可以很方便地实现
     * 1、遍历链表，并将访问过的结点存储到哈希表中
     * 2、判断结点是否在哈希表中，若存在则返回 此节点
     * 3、遍历结束，则返回 null
     *
     * 时间复杂度O(N)：其中 N 为链表中节点的数目。遍历整个链表的结点
     * 空间复杂度O(N)：其中 N 为链表中节点的数目。我们需要将链表中的每个节点都保存在哈希表当中。
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        ListNode temp = head;
        HashSet<ListNode> set = new HashSet<>();
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            set.add(temp);
        }
        return null;
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
 }