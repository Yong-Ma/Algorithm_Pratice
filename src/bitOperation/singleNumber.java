package bitOperation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @ClassName singleNumber
 * @description:
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-12-06 23:13
 * @Version 1.0
 **/
public class singleNumber {

    // 哈希表
    public int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : nums) {
            map.merge(a, 1, Integer::sum);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet() ) {
            if (entry.getValue() == 1) {
                res = entry.getKey();
            }
        }
        return res;
    }

    // 位运算
    public int singleNumber2(int[] nums) {

        int res = 0;
        for (int a : nums) {
            res = res ^ a;
        }
        return res;
    }

}
