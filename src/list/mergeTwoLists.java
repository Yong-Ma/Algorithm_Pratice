package list;

import java.util.ArrayList;

/**
 * @ClassName mergeTwoLists
 * @description:
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2022-01-01 22:34
 * @Version 1.0
 **/
public class mergeTwoLists {

    // 空间复杂度O(n + m)
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ArrayList<Integer> ret = new ArrayList<>();
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ret.add(list1.val);
                list1 = list1.next;
            } else {
                ret.add(list2.val);
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            ret.add(list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            ret.add(list2.val);
            list2 = list2.next;
        }
        ListNode node = new ListNode(-1);
        ListNode head = node;
        for (int i = 0; i < ret.size(); i++) {
            node.next = new ListNode(ret.get(i));
            node = node.next;
        }
        return head.next;
    }

    // 更加优雅的迭代方法,不占用更多空间
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        node.next =  null == list1 ? list2 : list1;
        return head.next;
    }
    // 递归
    public ListNode mergeTwoLists3(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists3(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists3(list1, list2.next);
            return list2;
        }
    }
}
