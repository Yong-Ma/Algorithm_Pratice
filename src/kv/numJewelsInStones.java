package kv;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName numJewelsInStones
 * @description:
 * 给你一个字符串 jewels代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。stones中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
 *
 * 示例 1：
 * 输入：jewels = "aA", stones = "aAAbbbb"
 * 输出：3
 *
 * 示例 2：
 * 输入：jewels = "z", stones = "ZZ"
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jewels-and-stones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-11-29 23:09
 * @Version 1.0
 **/
public class numJewelsInStones {

    public int numJewelsInStones(String jewels, String stones) {
        // 对宝石种类进行预处理
        Map<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < jewels.length(); i++) {
            map.put(jewels.charAt(i), true);
        }
        int count = 0;
        for (char c : stones.toCharArray()) {
            if (map.containsKey(c)) {
                count++;
            }
        }
        return count;
    }
}
