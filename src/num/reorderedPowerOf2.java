package num;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName reorderedPowerOf2
 * @description:
 * 给定正整数 N，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * 如果我们可以通过上述方式得到2的幂，返回 true；否则，返回 false。
 *
 * 示例 1：
 * 输入：1
 * 输出：true
 *
 * 示例 2：
 * 输入：10
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reordered-power-of-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-10-28 22:54
 * @Version 1.0
 **/
public class reorderedPowerOf2 {

    // 存储能转化成2的幂的数字字符串
    private static Set<String> powerOf2Digits = new HashSet<>();
    static {
        for (int i = 1; i < 1e9; i<<=1) {
            powerOf2Digits.add(countDigits(i));
        }
    }
    public static boolean reorderedPowerOf2(int n) {
        return powerOf2Digits.contains(countDigits(n));
    }
    // 返回该整数的每个数字出现的次数的字符串
    private static String countDigits(int n) {
        char[] cnt = new char[10];
        while (n > 0) {
            ++cnt[n % 10];
            n /= 10;
        }
        return new String(cnt);
    }

    // 测试
    public static void main(String[] args) {
        int n = 16;
        reorderedPowerOf2(16);
    }
}
