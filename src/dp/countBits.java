package dp;

/**
 * @ClassName countBits
 * @description:
 * 给你一个整数 n ，对于0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 *
 * 示例 2：
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-09-23 23:26
 * @Version 1.0
 **/
public class countBits {

    // 1、使用内置的函数
    public int[] countBits1(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = Integer.bitCount(i);
        }
        return bits;
    }
    // 2、手动计算，时间复杂度为O(n logn)
    public int[] countBits2(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = coutOnes(i);
        }
        return bits;
    }

    private int coutOnes(int i) {
        int count = 0;
        while (i > 0) {
            i &= (i-1);
            count++;
        }
        return count;
    }
    // 3、动态规划-最高有效位
    public int[] countBits3(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ( (i & (i - 1) )== 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }
}
