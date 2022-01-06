package num;

/**
 * @ClassName hammingDistance
 * @description:
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 *
 * 示例 1：
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * 示例 2：
 * 输入：x = 3, y = 1
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2022-01-06 23:52
 * @Version 1.0
 **/
public class hammingDistance {

    // 暴力
    public static int hammingDistance1(int x, int y) {
        String s1 = Integer.toBinaryString(x);
        String s2 = Integer.toBinaryString(y);
        int len1 = s1.length();
        int len2  = s2.length();
        if (len1 > len2) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < len1 - len2; i++) {
                stringBuilder.append("0");
            }
            s2 = stringBuilder.toString() + s2;
        } else if (len2 > len1) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < len2 - len1; i++) {
                stringBuilder.append("0");
            }
            s1 = stringBuilder.toString() + s1;
        }
        int ret = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ret++;
            }
        }
        return ret;
    }
    // 内置函数
    public static int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
    // 移位法
    public static int hammingDistance3(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            ret += s & 1;
            s >>= 1;
        }
        return ret;
    }



    public static void main(String[] args) {
        int x = 3, y = 1;
        hammingDistance1(x, y);
    }
}
