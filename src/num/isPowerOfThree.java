package num;

/**
 * @ClassName isPowerOfThree
 * @description:
 * 给定一个整数，写一个函数来判断它是否是 3的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 * 示例 1：
 *
 * 输入：n = 27
 * 输出：true
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 9
 * 输出：true
 * 示例 4：
 *
 * 输入：n = 45
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-09-23 22:13
 * @Version 1.0
 **/
public class isPowerOfThree {

    // 时间复杂度O(n)，会超时
    public boolean isPowerOfThree1(int n) {

        if (n == 0 ) {
            return Boolean.FALSE;
        }
        int i = 0;
        for (; i <= n / 3 ; i++) {
            if (Math.pow(3,  i) == n) {
                break;
            }
        }
        return i > n / 3 ? Boolean.FALSE : Boolean.TRUE;
    }

    // 时间复杂度O(log n)
    public boolean isPowerOfThree2(int n) {

        while (n != 0 && n % 3 == 0) {
            n/=3;
        }
        return n == 1;
    }
    // 在题目给定的 3232 位有符号整数的范围内，最大的 33 的幂为3^{19} = 1162261467,我们只需要判断n是否是 3^{19}的约数即可
    public boolean isPowerOfThree3(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

}
