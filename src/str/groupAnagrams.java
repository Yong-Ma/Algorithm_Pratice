package str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName groupAnagrams
 * @description:
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 *
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 * 提示：
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i]仅包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-12-24 21:28
 * @Version 1.0
 **/
public class groupAnagrams {
    // 只符合每个字符串字符不重复的情况
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        for(String str : strs) {
            int num = 0;
            for(int i = 0; i < str.length(); i++) {
                int position = str.charAt(i) - 'a';
                num |= (1 << position);
            }
            List<String> stringList = map.getOrDefault(num, new ArrayList<>());
            stringList.add(str);
            map.put(num, stringList);
        }
        List<List<String>> res = new ArrayList<>();
        map.forEach((k, v) -> {
            res.add(v);
        });
        return res;
    }
    // 使用排序
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortStr = new String(charArray);
            List<String> stringList = map.getOrDefault(sortStr, new ArrayList<>());
            stringList.add(str);
            map.put(sortStr, stringList);
        }
        return new ArrayList<>(map.values());
    }
}
