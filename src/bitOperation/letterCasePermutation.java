package bitOperation;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName letterCasePermutation
 * @description:
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 * 示例：
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入：S = "3z4"
 * 输出：["3z4", "3Z4"]
 *
 * 输入：S = "12345"
 * 输出：["12345"]
 *
 * 提示：
 * S的长度不超过12。
 * S仅由数字和字母组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-case-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-12-08 23:48
 * @Version 1.0
 **/
public class letterCasePermutation {

    public List<String> letterCasePermutation(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                count++;
            }
        }
        ArrayList<String> res = new ArrayList<>();
        if (count == 0) {
            return Arrays.asList(s);
        } else {
            for (int i = 0; i < (1 << count); i++) {
                boolean[] position = new boolean[count];
                // 判断需更改第几个字母的大小写
                for (int j = 0; j < count; j++) {
                    if ((i & (1 << j)) != 0) {
                        position[j] = true;
                    }
                }
                // 遍历到第几个字母
                int p = 0;
                StringBuilder stringBuilder = new StringBuilder();
                // 进行大小写更改
                for (int j = 0; j < s.toCharArray().length; j++) {
                    if (Character.isAlphabetic(s.charAt(j)) && position[p++]) {
                        if (Character.isLowerCase(s.charAt(j))) {
                            stringBuilder.append(Character.toUpperCase(s.charAt(j)));
                        } else {
                            stringBuilder.append(Character.toLowerCase(s.charAt(j)));
                        }
                    } else {
                        stringBuilder.append(s.charAt(j));
                    }
                }
                // 加入结果集里
                res.add(stringBuilder.toString());
            }
        }
        return res;
    }
}
