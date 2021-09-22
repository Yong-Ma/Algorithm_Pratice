package list;

/**
 * @ClassName listNode
 * @description: 用作其他算法的链表模拟
 * @author: mzy
 * @create: 2021-09-22 23:06
 * @Version 1.0
 **/
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
