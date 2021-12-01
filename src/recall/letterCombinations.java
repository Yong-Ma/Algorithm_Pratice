package recall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName letterCombinations
 * @description:
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-12-01 16:45
 * @Version 1.0
 **/
public class letterCombinations {

    private List<String> ans = new ArrayList<>();
    private StringBuilder strs = new StringBuilder();
    // 数字键盘对应的字母字符串
    private HashMap<Character, String> alphas = new HashMap<>();


    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return ans;
        }
        init();
        recall(digits, 0);
        StringBuffer stringBuffer = new StringBuffer();
        return ans;


    }

    private void recall(String digits, int i) {
        if (i == digits.length()) {
            ans.add(strs.toString());
            return;
        }
        String alpha = alphas.get(digits.charAt(i));
        for (int j = 0; j < alpha.length(); j++) {
            strs.append(alpha.charAt(j));
            recall(digits, i + 1);
            strs.deleteCharAt(strs.length() - 1);
        }
    }

    private void init() {
        alphas.put('2', "abc");
        alphas.put('3', "def");
        alphas.put('4', "ghi");
        alphas.put('5', "jkl");
        alphas.put('6', "mno");
        alphas.put('7', "pqrs");
        alphas.put('8', "tuv");
        alphas.put('9', "wxyz");
    }

}
