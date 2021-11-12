package str;

/**
 * @ClassName detectCapitalUse
 * @description:
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 *
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写，比如"Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：word = "USA"
 * 输出：true
 *
 * 示例 2：
 * 输入：word = "FlaG"
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/detect-capital
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-11-13 00:01
 * @Version 1.0
 **/
public class detectCapitalUse {

    public boolean detectCapitalUse(String word) {
        char[] wordArray = word.toCharArray();
        int len = wordArray.length;
        if (Character.isLowerCase(wordArray[0])) {
            // 如果第一个字符为小写，那么后面都需要为小写
            for (int i = 1; i < len; i++) {
                if (Character.isUpperCase(wordArray[i])) {
                    return false;
                }
            }
        } else {
            // 如果第一个字符为大写，那么后面要么全是大写，要么全是小写
            boolean isAllUpperCase = false;
            if (len > 1 && Character.isUpperCase(wordArray[1])) {
                // 第二个的大小写影响后续的字符，必须都一致为大写或小写
                isAllUpperCase = true;
            }
            for (int i = 2; i < len; i++) {
                if ( (isAllUpperCase && Character.isLowerCase(wordArray[i]) ) || (!isAllUpperCase && Character.isUpperCase(wordArray[i]) )) {
                    return false;
                }
            }
        }
        return true;
    }
}
