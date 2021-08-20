package list;

/**
 * 【来源】
 *  书中第二章第五题
 *
 * 【题目】
 * 给定一个单向链表的头节点 head， 以及两个整数 from 和 to，在单向链表上把第 from 个节
 * 点到第 to 个节点这一部分进行反转。
 * 例如：
 * 1->2->3->4->5->null， from=2， to=4
 * 调整结果为： 1->4->3->2->5->null
 * 再如：
 * 1->2->3->null， from=1， to=3
 * 调整结果为： 3->2->1->null
 * 【要求】
 * 1． 如果链表长度为 N，时间复杂度要求为 O(N)，额外空间复杂度要求为 O(1)。
 * 2． 如果不满足 1<=from<=to<=N，则不用调整。
 * 【解答】
 * 本题有可能存在换头的问题，比如题目的第二个例子，所以函数应该返回调整后的新头节点，整个处理过程如下：
 * 1． 先判断是否满足 1≤ from≤ to≤ N，如果不满足，则直接返回原来的头节点。
 * 2． 找到第 from-1 个节点 fPre 和第 to+1 个节点 tPos。 fPre 就是要反转部分的前一个节点，
 * tPos 是反转部分的后一个节点。把反转的部分先反转，然后正确地连接 fPre 和 tPos。
 * 例如： 1->2->3->4->null，假设 fPre 为节点 1， tPos 为节点 4，要反转部分为 2->3。先反转成
 * 3->2，然后 fPre 连向节点 3，节点 2 连向 tPos，就变成了 1->3->2->4->null。
 * 3． 如果 fPre 为 null，说明反转部分是包含头节点的，则返回新的头节点，也就是没反转之
 * 前反转部分的最后一个节点，也是反转之后反转部分的第一个节点；如果 fPre 不为 null， 则返
 * 回旧的头节点。
 *
 * @author yong
 * @date 2021/8/20 22:57
 */
public class reversePartList {

    public Node reversePart(Node head, int from, int to) {
        int len = 0;
        Node node1 = head;
        Node fPre = null;
        Node tPos = null;
        while (node1 != null) {
            len++;
            fPre = len == from - 1 ? node1 : fPre;
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }
        if (from > to || from < 1 || to > len) {
            return head;
        }
        node1 = fPre == null ? head : fPre.next;
        Node node2 = node1.next;
        node1.next = tPos;
        Node next = null;
        while (node2 != tPos) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (fPre != null) {
            fPre.next = node1;
            return head;
        }
        return node1;
    }
}
