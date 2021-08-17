package stack_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 【来源】
 *  书（readme.md中有提及这本书）中第一章第8道题
 *
 * 【题目】
 * 给定一个不含有重复值的数组 arr，找到每一个 i 位置左边和右边离 i 位置最近且值比 arr[i]小的位置。返回所有位置相应的信息。
 *
 * 【举例】
 * arr = {3,4,1,5,6,2,7}
 * 返回如下二维数组作为结果：
 * {
 * {-1, 2},
 * { 0, 2},
 * {-1,-1},
 * { 2, 5},
 * { 3, 5},
 * { 2,-1},
 * { 5,-1}
 * }
 * 【解答】
 * 请看书中解答
 *
 * @author yong
 * @date 2021/8/17 22:01
 */
public class getNearLessNum {

    // 暴力方法，复杂度O(N^2)
    private static int[][] badWay(int [] arr) {

        int len = arr.length;
        int[][] res = new int[len][2];
        for (int i = 0; i < len; i++) {
            int leftLessIndex = -1;
            int rightLessIndex = -1;
            int cur = i-1;
            while (cur >= 0) {
                if (arr[cur] < arr[i]) {
                    leftLessIndex = cur;
                    break;
                }
                cur--;
            }
            cur = i+1;
            while (cur < len) {
                if (arr[cur] < arr[i]) {
                    rightLessIndex = cur;
                    break;
                }
                cur++;
            }
            res[i][0] = leftLessIndex;
            res[i][1] = rightLessIndex;
        }
        return res;
    }

    // 对于数组不重复的情况，使用单调栈的方法
    private static int[][] getNearLessNumIndex(int [] arr) {

        int len = arr.length;
        Stack<Integer> stack = new Stack<>();
        int [][] res =new int[len][2];
        for (int i = 0; i < len; i++) {

            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                Integer pop = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                int rightLessIndex = i;
                res[pop][0] = leftLessIndex;
                res[pop][1] = rightLessIndex;

            }
            stack.push(i);
        }
        // 对栈中剩余的进行清算
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            res[pop][0] = leftLessIndex;
            res[pop][1] = -1;
        }

        return res;
    }

    // 如果数组中有重复值，使用下面的方法
    private static int[][] getNearLess(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> popIs = stack.pop();
                // 取位于下面位置的列表中，最晚加入的那个
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(
                        stack.peek().size() - 1);
                for (Integer popi : popIs) {
                    res[popi][0] = leftLessIndex;
                    res[popi][1] = i;
                }
            }
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        while (!stack.isEmpty()) {
            List<Integer> popIs = stack.pop();
            // 取位于下面位置的列表中，最晚加入的那个
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(
                    stack.peek().size() - 1);
            for (Integer popi : popIs) {
                res[popi][0] = leftLessIndex;
                res[popi][1] = -1;
            }
        }
        return res;
    }
    // 测试
    public static void main(String[] args) {

        int [] arr = {3,4,1,5,6,2,7};
        int[][] badWay = badWay(arr);
        System.out.println(Arrays.deepToString(badWay));
        int [][] goodWay = getNearLessNumIndex(arr);
        System.out.println(Arrays.deepToString(goodWay));

        int [] arr2 = {3,1,3,4,3,5,3,2,2};
        int [][] goodWay2 = getNearLess(arr2);
        System.out.println(Arrays.deepToString(goodWay2));
    }
}
