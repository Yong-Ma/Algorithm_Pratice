package stack_queue;

import java.util.Stack;

/**
 * [来源】
 * 书（readme.md中有提及这本书）中第3道题
 *
 *【题目】
 * 一个栈依次压入 1、 2、 3、 4、 5， 那么从栈顶到栈底分别为 5、 4、 3、 2、 1。将这个栈转置后，
 * 从栈顶到栈底为 1、 2、 3、 4、 5，也就是实现栈中元素的逆序，但是只能用递归函数来实现， 不能用其他数据结构。
 *
 *【解答】
 * 看书中解答
 * @author yong
 * @date 2021/8/15 20:57
 */
public class reverseStack {

    // 从栈中获取栈底元素并将它从栈中移除
    private static int getAndRemoveLastElement(Stack<Integer> stack) {

        Integer res = stack.pop();
        if (stack.isEmpty()) {
            return res;
        }else {
            int last = getAndRemoveLastElement(stack);
            stack.push(res);
            return last;
        }
    }

    // 逆转栈元素
    private static void reverse(Stack<Integer> stack) {

        if (stack.isEmpty()) {
            return;
        }else {
            int last = getAndRemoveLastElement(stack);
            reverse(stack);
            stack.push(last);
        }

    }

    // 测试
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("原栈：" + stack);
        reverse(stack);
        System.out.println("逆序后：" + stack);
    }
}
