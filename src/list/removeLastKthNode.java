package list;

/**
 * 【来源】
 * 书中第二章第二题
 * 【题目】
 * 分别实现两个函数，一个可以删除单链表中倒数第 K 个节点，另一个可以删除双链表中倒
 * 数第 K 个节点。
 * 【要求】
 * 如果链表长度为 N，时间复杂度达到 O(N)，额外空间复杂度达到 O(1)。
 *
 * @author yong
 * @date 2021/8/18 22:00
 */
public class removeLastKthNode {

    public Node removeLastKthNode(Node head, int lastKth) {

        if (head == null || lastKth < 1) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }


    public DoubleNode removeLastKthNode(DoubleNode head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        DoubleNode cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
            head.last = null;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if (newNext != null) {
                newNext.last = cur;
            }
        }
        return head;
    }
}
