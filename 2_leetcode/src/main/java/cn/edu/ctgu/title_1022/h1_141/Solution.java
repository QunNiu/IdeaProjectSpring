package cn.edu.ctgu.title_1022.h1_141;

import java.util.HashSet;

/**
 *  参考地址：https://www.cnblogs.com/yorkyang/p/10876604.html
 *  leetcode第141题
 * @author NiuQun
 * @date 2021/10/22
 */
public class Solution {
    public static void main(String[] args) {

    }

    /**
     * 判断一个链表是否有环
     * 双指针法
     * 解题思路：
     * 我们使用两个指针，fast 与 slow。
     * 它们起始都位于链表的头部。随后，slow 指针每次向后移动一个位置，而fast 指针向后移动两个位置。如果链表中存在环，
     * 则 fast 指针最终将再次与 slow 指针在环中相遇。
     *
     * 时间复杂度O(N)：其中 N 为链表中节点的数目。在最初判断快慢指针是否相遇时，slow 指针走过的距离不会超过链表的总长度
     * 空间复杂度O(1)：额外使用的指针占用常数空间
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇了，说明有环
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 哈希表法：
     * 解题思路：
     * 我们遍历链表中的每个节点，并将它记录下来；一旦遇到了此前遍历过的节点，就可以判定链表中存在环。借助哈希表可以很方便地实现
     * 1、遍历链表，并将访问过的结点存储到哈希表中
     * 2、判断结点是否在哈希表中，若存在则返回 true
     * 3、遍历结束，则返回 false
     *
     * 时间复杂度O(N)：其中 N 为链表中节点的数目。遍历整个链表的结点
     * 空间复杂度O(N)：其中 N 为链表中节点的数目。我们需要将链表中的每个节点都保存在哈希表当中。
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        ListNode temp = head;
        HashSet<ListNode> set = new HashSet<>();
        while (temp != null) {
            // 之前已经走过该结点，说明有环
            if (set.contains(temp)) {
                return true;
            }
            // 每走一个结点就把该结点存入set中
            set.add(temp);
            temp = temp.next;
        }
        return false;
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
