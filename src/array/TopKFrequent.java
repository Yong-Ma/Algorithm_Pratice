package array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @ClassName TopKFrequent
 * @description:
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 提示：
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2022-02-13 18:23
 * @Version 1.0
 **/
public class TopKFrequent {

    // 1、使用hashmap存储出现频次,时间复杂度O(N ^2),空间复杂度为O（N）
    public int[] topKFrequent1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }
        int[] res = new int[k];
        List<Integer> maxCount = map.values().stream().
                sorted(Comparator.reverseOrder()).
                limit(k).
                collect(Collectors.toList());
        for (int i = 0; i < k; i++) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue().equals(maxCount.get(i))) {
                    res[i] = entry.getKey();
                    map.remove(entry.getKey());
                    break;
                }
            }
        }
        return res;
    }

    // 2、小顶堆

    // 时间复杂度：O(Nlogk)，其中 N 为数组的长度。我们首先遍历原数组，并使用哈希表记录出现次数，每个元素需要 O(1) 的时间，共需 O(N) 的时间。
    // 随后，我们遍历「出现次数数组」，由于堆的大小至多为 k，因此每次堆操作需要 O(logk) 的时间，共需 O(Nlogk) 的时间。二者之和为 O(Nlogk)。
    // 空间复杂度：O(N)。哈希表的大小为 O(N)，而堆的大小为 O(k)，共计为 O(N)。

    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> occurrences = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            occurrences.merge(nums[i], 1, Integer::sum);
        }
        // int[0] 为数， int[1]为出现次数，
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (minHeap.size() == k) {
                if (minHeap.peek()[1] < count) {
                    minHeap.poll();
                    minHeap.offer(new int[] {num, count});
                }
            } else {
                minHeap.offer(new int[]{num, count});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll( )[0];
        }
        return res;
    }

}
