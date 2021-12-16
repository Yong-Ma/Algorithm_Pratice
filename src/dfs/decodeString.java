package dfs;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName decodeString
 * @description:
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。
 *
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 *
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 *
 * 示例 3：
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 *
 * 示例 4：
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-12-16 21:16
 * @Version 1.0
 **/
public class decodeString {

    // 递归
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(Character.isDigit(c)) {
                int j = i + 1;
                while(Character.isDigit(chars[j])) {
                    j++;
                }
                int num = Integer.parseInt(s.substring(i, j));
                int start = j + 1;
                Deque<Character> stack = new LinkedList<>();
                stack.push(chars[j]);
                j++;
                while(!stack.isEmpty() && j < chars.length) {
                    if(chars[j] == '[') {
                        stack.push(chars[j]);
                    } else if(chars[j] == ']') {
                        stack.pop();
                    }
                    j++;
                }
                String repeatStr = decodeString(s.substring(start, j - 1));
                for(int k = 0; k < num; k++) {
                    sb.append(repeatStr);
                }
                i = j - 1;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
