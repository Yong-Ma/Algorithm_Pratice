package list;

/**
 * 【来源】
 * 书中第二章第三题
 *【题目】
 * 给定链表的头节点 head，实现删除链表的中间节点的函数。
 * 例如：
 * 不删除任何节点；
 * 1->2，删除节点 1；
 * 1->2->3，删除节点 2；
 * 1->2->3->4，删除节点 2；
 * 1->2->3->4->5，删除节点 3；
 * 进阶：
 * 给定链表的头节点 head、 整数 a 和 b，实现删除位于 a/b 处节点的函数。
 * 例如：
 * 链表： 1->2->3->4->5，假设 a/b 的值为 r。
 * 如果 r 等于 0，不删除任何节点；
 * 如果 r 在区间(0, 1/5]上，删除节点 1；
 * 如果 r 在区间(1/5, 2/5]上，删除节点 2；
 * 如果 r 在区间(2/5, 3/5]上，删除节点 3；
 * 如果 r 在区间(3/5, 4/5]上，删除节点 4；
 * 如果 r 在区间(4/5, 1]上，删除节点 5；
 * 如果 r 大于 1，不删除任何节点。
 *
 * @author yong
 * @date 2021/8/19 22:56
 */
public class removeNode {

    // 去除链表的中间节点
    private static Node removeMidNode(Node head) {

        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next !=null) {
            pre = pre.next;
            cur = head.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }
    // 删除a/b处的节点
    private static Node removeByRatio(Node head, int a, int b) {

        if (a < 1 || a/b > 1 || head == null)  {
            return head;
        }

        int n = 0;
        Node cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        n =(int) Math.ceil(((double) (a * n)) / (double) b);
        if (n == 1) {
            head =  head.next;
        }
        if (n > 1) {
            cur = head;
            while (--n != 1) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
