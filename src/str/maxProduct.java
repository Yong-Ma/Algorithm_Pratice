package str;

/**
 * @ClassName maxProduct
 * @description:
 * 给定一个字符串数组words，找到length(word[i]) * length(word[j])的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *
 * 示例1:
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 *
 * 示例 2:
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 *
 * 示例 3:
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-11-17 17:46
 * @Version 1.0
 **/
public class maxProduct {

    public int maxProduct(String[] words) {
        int len = words.length;
        int [] marks = new int[len];
        // 对每个单词进行预处理，二进制位上从第0位到第25位分别标记，该位上为1则代表这个单词有相应的字符
        for (int i = 0; i < len; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                marks[i] |= 1 << word.charAt(j) - 'a';
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len ; j++) {
                // 如果这2个单词没有重复的字符
                if ((marks[i] & marks[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
