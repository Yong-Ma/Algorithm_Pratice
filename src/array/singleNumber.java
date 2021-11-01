package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName singleNumber
 * @description:
 * 给定一个整数数组nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？

 * 示例 1：
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 *
 * 示例 2：
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 *
 * 示例 3：
 * 输入：nums = [0,1]
 * 输出：[1,0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-10-30 22:47
 * @Version 1.0
 **/
public class singleNumber {

    // 时间空间复杂度都为O（n），实际遍历了两遍
    public int[] singleNumber1(int[] nums) {
        HashMap<Integer, Integer> cntMap = new HashMap<>();
        for (int a : nums) {
            cntMap.merge(a, 1, Integer::sum);
        }
        int [] res = new int[2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() == 1) {
                res[i++] = entry.getKey();
            }
        }
        return res;
    }

    // 第二种做法,空间复杂度为O(1)
    public int[] singleNumber2(int[] nums) {
        int xor = 0;
        // 得到数组所有值异或的结果，因为只有2个数只出现一次，其他均为2次，所以最终的结果是这2个只出现一次的值异或的结果
        for(int a : nums) {
            xor ^= a;
        }
        // 获取二进制最低位的1
        xor = xor & -xor;
        // 2个数异或得到的二进制里的表明在该位上2个数是不一样的，所以可以区分这2个数，放在不同的分类中
        int type1 = 0, type2 = 0;
        for(int a : nums) {
            if ((a & xor) == 0) {
                type1 ^= a;
            }else {
                type2 ^= a;
            }
        }
        return new int[]{type1, type2};
    }

}
