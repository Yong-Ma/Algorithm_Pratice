package stack_queue;

import java.util.Stack;

/**
 * [来源】
 * 书（readme.md中有提及这本书）中第5道题
 * 【题目】
 * 一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一个栈。
 * 除此之外， 可以申请新的变量，但不能申请额外的数据结构。如何完成排序？
 *
 * 【解答】
 * 将要排序的栈记为 stack，申请的辅助栈记为 help。在 stack 上执行 pop 操作，弹出的元素记为 cur。
 * （1）如果 cur 小于或等于 help 的栈顶元素，则将 cur 直接压入 help；
 * （2）如果 cur 大于 help 的栈顶元素，则将 help 的元素逐一弹出，逐一压入 stack，直到 cur小于或等于 help 的栈顶元素，再将 cur 压入 help。
 * 一直执行以上操作，直到 stack 中的全部元素都压入到 help。最后将 help 中的所有元素逐一压入 stack，即完成排序。
 *
 * @author yong
 * @date 2021/8/15 22:25
 */
public class sortStackByStack {

    private static void sortStackByStack(Stack<Integer> stack) {

        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            while (!help.isEmpty() && cur > help.peek()) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }

    }

    // 测试
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(2);
        stack.push(4);
        System.out.println("原栈：" + stack);
        sortStackByStack(stack);
        System.out.println("排序后：" + stack);

    }
}
