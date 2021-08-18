package list;

/**
 * 【来源】
 *  书中第二章第一题
 * 【题目】
 * 给定两个有序链表的头指针 head1 和 head2，打印两个链表的公共部分。
 * 【解答】
 * 如果 head1 的值小于 head2，则 head1 往下移动。
 * 如果 head2 的值小于 head1，则 head2 往下移动。
 * 如果 head1 的值与 head2 的值相等，则打印这个值，然后 head1 与 head2 都往下移动。
 * head1 或 head2 有任何一个移动到 null， 则整个过程停止。
 *
 * @author yong
 * @date 2021/8/18 21:36
 */
public class printCommonPart {

    private static void printCommonPart(Node head1, Node head2) {

        System.out.print("Common Part: ");
        while (head1 !=null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            }else if (head1.value > head2.value) {
                head2 = head2.next;
            }else {
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }

    // 测试
    public static void main(String[] args) {

        Node head1 = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        head1.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        Node head2 =new Node(1);
        head2.next = new Node(3);
        printCommonPart(head1, head2);
    }
}
