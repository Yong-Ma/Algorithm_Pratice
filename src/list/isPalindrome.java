package list;

import java.util.Stack;

/**
 * 【来源】
 * 书中第二章第七题
 * 【题目】
 * 给定一个链表的头节点 head，请判断该链表是否为回文结构。
 * 例如：
 * 1->2->1，返回 true。
 * 1->2->2->1，返回 true。
 * 15->6->15，返回 true。
 * 1->2->3，返回 false。
 * 进阶：
 * 如果链表长度为 N，时间复杂度达到 O(N)，额外空间复杂度达到 O(1)。
 *
 * @author yong
 * @date 2021/8/24 20:57
 */
public class isPalindrome {


    // 这种方法会额外占用O（N）的空间
    private static Boolean isPalindrome1(Node head) {

        if (head == null || head.next == null) {
            return false;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head !=null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 这个方法将栈空间缩小一半
    private Boolean isPalindrome2(Node head) {

        if (head == null || head.next == null) {
            return true;
        }
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
