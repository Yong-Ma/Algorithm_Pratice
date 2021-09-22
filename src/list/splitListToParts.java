package list;

import java.util.ArrayList;

/**
 * @ClassName splitListToParts
 * @description:
 * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 *
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
 *
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
 *
 * 返回一个由上述 k 部分组成的数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-linked-list-in-parts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-09-22 23:11
 * @Version 1.0
 **/
public class splitListToParts {

    // 1、粗糙的做法
    public static ListNode[] splitListToParts1(ListNode head, int k) {

        // 获得愿链表的长度
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        cur = head;
        // 存储结果
        ArrayList<ListNode> res = new ArrayList<>();
        // 1、链表长度不足要划分的份数，每部分最多一个，最后部分有可能为空
        if (len <= k) {
            for (int i = 0; i < k; i++) {
                if (cur != null) {
                    res.add(new ListNode(cur.val));
                    cur = cur.next;
                }else {
                    res.add(null);
                }
            }
        }else {
            // 每部分链表的长度
            int everyPartNum = len / k;
            // 有多少部分的链表会比其它部分长1
            int extraNum = Math.floorMod(len, k);
            // 总共就只有k段链表
            for (int i = 0; i < k; i++) {
                // 每段链表有everyPartNum个值
                ListNode newHead = null;
                ListNode curHead = null;
                curHead = cur;
                newHead =curHead;
                cur = cur.next;
                for (int j = 1; j < everyPartNum; j++) {
                    curHead.next =cur;
                    curHead = curHead.next;
                    cur = cur.next;
                }
                // 前extraNum段链表再增加一个值
                if (extraNum != 0) {
                    curHead.next = cur;
                    curHead = curHead.next;
                    cur = cur.next;
                    extraNum--;
                }
                curHead.next = null;
                res.add(newHead);
            }

        }
        return res.toArray(new ListNode[]{});
    }

    // 2、优雅的做法
    public ListNode[] splitListToParts2(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        int quotient = n / k, remainder = n % k;

        ListNode[] parts = new ListNode[k];
        ListNode curr = head;
        for (int i = 0; i < k && curr != null; i++) {
            parts[i] = curr;
            int partSize = quotient + (i < remainder ? 1 : 0);
            for (int j = 1; j < partSize; j++) {
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return parts;
    }

    // 测试
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        splitListToParts1(node1, 3);
    }
}
