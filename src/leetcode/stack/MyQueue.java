package leetcode.stack;

import java.util.Stack;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *
 * 提示：
 * 1 <= x <= 9
 * 最多调用 100 次 push、pop、peek 和 empty
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yong
 * @date 2021/8/22 17:38
 */
public class MyQueue {

    private Stack<Integer> stackPush ;
    private Stack<Integer> stackPop ;
    /** Initialize your data structure here. */
    public MyQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackPush.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        if (!stackPop.isEmpty()) {
            return stackPop.pop();
        }
        while (!stackPush.isEmpty()) {
            stackPop.push(stackPush.pop());
        }
        return stackPop.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!stackPop.isEmpty()) {
            return stackPop.peek();
        }
        while (!stackPush.isEmpty()) {
            stackPop.push(stackPush.pop());
        }
        return stackPop.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {

        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
