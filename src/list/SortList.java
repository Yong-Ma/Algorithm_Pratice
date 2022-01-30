package list;

/**
 * @ClassName SortList
 * @description:
 * 对链表进行排序
 *
 * 这道题可以用双指针+归并排序算法解决，主要以下四个步骤
 * 1. 快慢指针法，遍历链表找到中间节点
 * 2. 中间节点切断链表
 * 3. 分别用归并排序排左右子链表
 * 4. 合并子链表
 *
 * @author: mzy
 * @create: 2022-01-30 21:52
 * @Version 1.0
 **/
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 快慢指针
        ListNode slow = head, fast = head;
        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 找到中间节点
        ListNode mid =slow.next;
        // 断开这2部分，切断链表
        slow.next = null;
        // 递归，对左右部分再进行切分
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        // 合并左右链表
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                tmp.next = left;
                left = left.next;
            } else {
                tmp.next = right;
                right = right.next;
            }
            tmp = tmp.next;
        }
        if (left != null) {
            tmp.next = left;
        }
        if (right != null) {
            tmp.next = right;
        }
        return head.next;
    }
}
