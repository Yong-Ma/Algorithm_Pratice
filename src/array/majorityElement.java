package array;

import java.util.*;


/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例1：
 * 输入：[3,2,3]
 * 输出：3
 *
 * 示例2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yong
 * @date 2021/8/30 22:50
 */
public class majorityElement {

    // 1.使用排序方法
    public int majorityElement1(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    // 2.使用哈希表、
    public int majorityElement2(int[] nums) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int maxValue = 1;
        for (int a : nums) {
            hashMap.merge(a,1,Integer::sum);
            maxValue = Integer.max(maxValue, hashMap.get(a));
        }
        // 对数组中相同的数分组计数还可用流处理
//        Map<Integer, Long> hashMap = Arrays.stream(nums).boxed().collect
//                (groupingBy(Integer::intValue, collectingAndThen(counting(), a -> a)));
        for (Map.Entry<Integer, Integer> entry: hashMap.entrySet()) {
            if (entry.getValue() == maxValue) {
                return entry.getKey();
            }
        }
        return -1;
    }

}
