package str;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static java.util.stream.Collectors.*;

/**
 * @ClassName findLongestWord
 * @description:
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * 示例 1：
 *
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * 示例 2：
 *
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-09-15 00:05
 * @Version 1.0
 **/
public class findLongestWord {

    // 1、双指针法
    public String findLongestWord(String s, List<String> dictionary) {

        ArrayList<String> res = new ArrayList<>();
        for (String t : dictionary) {
            int i = 0, j =0;
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) == t.charAt(j)) {
                    j++;
                }
                i++;
            }
            if (j == t.length()) {
                res.add(t);
            }
        }
        Comparator<String> comparator = (o1, o2) -> {
            int a = o1.length() - o2.length();
            if ( a == 0 ) {
                return -o1.compareTo(o2);
            }
            return a;
        };
        return res.stream().max(comparator).orElse("");
    }
}
