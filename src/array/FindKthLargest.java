package array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @ClassName findKthLargest
 * @description:
 * @author: mzy
 * @create: 2022-02-05 22:14
 * @Version 1.0
 **/
public class FindKthLargest {

    private static Random random = new Random(System.currentTimeMillis());

    // 1、使用API，暴力，平均时间负责度O(N * logN), 空间复杂度O（logN）
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // 2、减而治之（逐渐缩小问题规模）
    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        int left = 0, right = len - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[target];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    // 3、使用最小堆,时间复杂度O（N * log(K), 空间复杂度O(K)
    public int findKthLargest3(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < len; i++) {
            Integer minNumOfHeap = minHeap.peek();
            if (minNumOfHeap < nums[i]) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }


    private int partition(int[] nums, int left, int right) {
        // 在区间随机选择一个元素作为标定点
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums, left, randomIndex);
        }

        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, left, j);
        return j;
    }


    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}
