package list;

/**
 * 【来源】
 * 书中第二章第四题
 * 【题目】
 * 分别实现反转单向链表和反转双向链表的函数。
 * 【要求】
 * 如果链表长度为 N，时间复杂度要求为 O(N)，额外空间复杂度要求为 O(1)。
 * @author yong
 * @date 2021/8/20 22:32
 */
public class reverseList {


    // 单向链表
    private static Node reverseList(Node head) {

        if (head == null || head.next == null) {
            return head;
        }
        Node pre = null;
        Node next = null;
        while (head !=null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 双向链表
    private static DoubleNode reverseList(DoubleNode head) {

        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
