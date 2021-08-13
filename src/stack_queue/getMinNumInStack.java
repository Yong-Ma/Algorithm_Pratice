package stack_queue;

import java.util.Stack;

/**
 *
 * 【来源】
 *  书（readme.md中有提及这本书）中第一道题
 * [题目】
 * 实现一个特殊的栈， 在实现栈的基本功能的基础上， 再实现返回栈中最小元素的操作。
 *
 *【要求】
 * 1． pop、 push、 getMin 操作的时间复杂度都是 O(1)。
 * 2． 设计的栈类型可以使用现成的栈结构。
 *
 * [解决方法一]
 * 使用两个栈来完成这项工作，一个栈stackData正常进行出栈入栈，另外一个栈stackMin保存第一个栈中数据的最小值
 * 入栈时stackMin判断当前栈是否为空，为空直接push；若当前栈中有数据且要入栈的数小于等于现在stackMin中栈顶的数，则将数据同时push到两个栈中
 * 出栈时判断stackData中要pop的值是否与stackMin中的栈顶值一致，若一致则两个栈同时pop，否则只popstackData的栈顶值
 *
 * 【解决方法二】
 * 以下内容为复制书中的内容
 * （1） 压入数据规则
 * 假设当前数据为 newNum，先将其压入 stackData。然后判断 stackMin 是否为空。
 * 如果为空，则 newNum 也压入 stackMin； 如果不为空， 则比较 newNum 和 stackMin 的栈顶
 * 元素中哪一个更小。
 * 如果 newNum 更小或两者相等，则 newNum 也压入 stackMin； 如果 stackMin 中栈顶元素小，则把 stackMin 的栈顶元素重复压入 stackMin，即在栈顶元素上再压入一个栈顶元素。
 * （ 2） 弹出数据规则
 * 在 stackData 中弹出数据，弹出的数据记为 value； 弹出 stackMin 中的栈顶， 返回 value。
 * 很明显可以看出，压入与弹出规则是对应的。
 * （ 3） 查询当前栈中的最小值操作
 * 由上文的压入数据规则和弹出数据规则可知， stackMin 始终记录着 stackData 中的最小值，
 * 所以 stackMin 的栈顶元素始终是当前 stackData 中的最小值。
 *
 * @author yong
 * @date 2021/8/13 22:30
 */
public class getMinNumInStack {

    private Stack<Integer> stackData = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();


    // 入栈
    private void pushOneNum(Integer newNum) {

        if (stackMin.isEmpty() || newNum <= stackMin.peek()) {
            stackMin.push(newNum);
        }
        stackData.push(newNum);

    }

    // 出栈
    private Integer popOneNum() {

        if (stackData.isEmpty()) {
            throw new RuntimeException("栈中数据为空，无数据可弹出！！！");
        }
        Integer popNum = stackData.pop();
        if (popNum.equals(stackMin.peek())) {
            stackMin.pop();
        }
        return popNum;
    }

    // 获取最小值
    private Integer getMinNUm() {

        if (stackMin.isEmpty()) {
            throw new RuntimeException("栈中无数据");
        }
        return stackMin.peek();
    }

    // 测试
    public static void main(String[] args) {

        getMinNumInStack stack = new getMinNumInStack();
        stack.pushOneNum(3);
        stack.pushOneNum(4);
        stack.pushOneNum(5);
        stack.pushOneNum(2);
        stack.pushOneNum(1);
        System.out.println("弹出第一个值：" + stack.popOneNum());
        System.out.println("弹出第二个值：" + stack.popOneNum());
        System.out.println("获取当前最小值：" + stack.getMinNUm());
    }
}
