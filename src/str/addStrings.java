package str;

import java.math.BigInteger;

/**
 * @ClassName addStrings
 * @description:
 * 给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。
 *
 * 示例 1：
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 *
 * 示例 2：
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 *
 * 示例 3：
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 *
 * 提示：
 * 1 <= num1.length, num2.length <= 104
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-12-22 22:01
 * @Version 1.0
 **/
public class addStrings {

    // 使用API
    public String addStrings1(String num1, String num2) {
        return new BigInteger(num1).add(new BigInteger(num2)).toString();
    }

    // 模拟加法
    public String addStrings2(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int add = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j>= 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + add;
            res.append(sum % 10);
            add = sum / 10;
            i--;
            j--;
        }
        if (add != 0) {
            res.append(add);
        }
        res.reverse();
        return res.toString();
    }

}
