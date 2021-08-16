package stack_queue;

import java.util.LinkedList;

/**
 * 【来源】
 * 书中第一章
 *
 * 【题目】
 * 有一个整型数组 arr 和一个大小为 w 的窗口从数组的最左边滑到最右边，窗口每次向右边滑一个位置。
 * 例如， 数组为[4,3,5,4,3,3,6,7]，窗口大小为 3 时：
 * [4 3 5] 4 3 3 6 7 窗口中最大值为 5
 * 4 [3 5 4] 3 3 6 7 窗口中最大值为 5
 * 4 3 [5 4 3] 3 6 7 窗口中最大值为 5
 * 4 3 5 [4 3 3] 6 7 窗口中最大值为 4
 * 4 3 5 4 [3 3 6] 7 窗口中最大值为 6
 * 4 3 5 4 3 [3 6 7] 窗口中最大值为 7
 * 如果数组长度为 n，窗口大小为 w，则一共产生 n-w+1 个窗口的最大值。
 * 请实现一个函数。
 * 输入：整型数组 arr，窗口大小为 w。
 * 输出：一个长度为 n-w+1 的数组 res， res[i]表示每一种窗口状态下的最大值。
 * 以本题为例，结果应该返回{5,5,5,4,6,7}
 *
 * @author yong
 * @date 2021/8/16 22:48
 */
public class getMaxWindow {

    public int[] getMaxWindow(int[] arr, int w) {

        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

}
