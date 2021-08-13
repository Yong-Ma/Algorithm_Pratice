package stack_queue;

import java.util.Stack;

/**
 * [来源】
 * 书（readme.md中有提及这本书）中第2道题
 *
 *【题目】
 * 编写一个类，用两个栈实现队列，支持队列的基本操作（add、 poll、 peek）。
 *
 *【解决】
 * 队列的出队是先进先出的，而栈是先进后出的，用一个栈是无法转化成队列的，因而使用2个栈
 * 使用一个栈stackPush做为数据入队，另外一个栈stackPop用于出队
 * 入队时统一将数据放入stackPush,出队时判断stackPop是否为空
 * 为空则将stackPush的数据全部弹出到stackPop再将stackPop的栈顶元素弹出；不为空则直接将stackPop的栈顶元素弹出
 *
 * @author yong
 * @date 2021/8/13 23:46
 */
public class twoStackAsQueue {

    private Stack<Integer> stackPush = new Stack<>();
    private Stack<Integer> stackPop = new Stack<>();

    // 入队
    private void add(Integer newNum) {
        stackPush.push(newNum);
    }

    // 出队
    private Integer poll() {

        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("无数据可弹出");
        }
        if (stackPop.isEmpty() && !stackPush.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }

        }
        return stackPop.pop();
    }

    // 获取队头元素
    private Integer peek() {

        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("无数据可获取");
        }
        if (stackPop.isEmpty() && !stackPush.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }

        }
        return stackPop.peek();
    }

    // 测试
    public static void main(String[] args) {

        twoStackAsQueue queue = new twoStackAsQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("第一次出队：" + queue.poll()); // 结果应该为1
        queue.add(4);
        System.out.println("第二次出队：" + queue.poll()); // 结果应该为2
        queue.add(5);
        System.out.println("第一次获取对头元素：" + queue.poll()); // 结果应该为3

    }

}
