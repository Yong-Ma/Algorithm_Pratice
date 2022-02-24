package array;

import java.util.HashMap;

/**
 * @ClassName distributeCandies
 * @description:
 * Alice 有 n 枚糖，其中第 i 枚糖的类型为 candyType[i] 。Alice 注意到她的体重正在增长，所以前去拜访了一位医生。
 * 医生建议 Alice 要少摄入糖分，只吃掉她所有糖的 n / 2 即可（n 是一个偶数）。Alice 非常喜欢这些糖，她想要在遵循医生建议的情况下，尽可能吃到最多不同种类的糖。
 * 给你一个长度为 n 的整数数组 candyType ，返回： Alice 在仅吃掉 n / 2 枚糖的情况下，可以吃到糖的最多种类数。
 *
 * 示例 1：
 * 输入：candyType = [1,1,2,2,3,3]
 * 输出：3
 * 解释：Alice 只能吃 6 / 2 = 3 枚糖，由于只有 3 种糖，她可以每种吃一枚。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distribute-candies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-11-01 23:02
 * @Version 1.0
 **/
public class distributeCandies {

    public int distributeCandies(int[] candyType) {
        int len = candyType.length ;
        // key为种类， value 为数量
        HashMap<Integer, Integer> typeMap = new HashMap<>(len);
        for (int a : candyType) {
            typeMap.merge(a, 1, Integer::sum);
            // 也可以下面这样写，不建议
//            if (typeMap.containsKey(a)) {
//                typeMap.put(a, typeMap.get(a) + 1);
//            }else {
//                typeMap.put(a, 1);
//            }
            //typeMap.put(a, typeMap.getOrDefault(a, 1) + 1);
        }
        return Math.min(typeMap.size(), len / 2);
    }
}
