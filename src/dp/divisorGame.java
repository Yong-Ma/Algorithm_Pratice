package dp;

/**
 * @ClassName divisorGame
 * @description:
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * 最初，黑板上有一个数字N。在每个玩家的回合，玩家需要执行以下操作：
 * 选出任一x，满足0 < x < N 且N % x == 0。
 * 用 N - x替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * 只有在爱丽丝在游戏中取得胜利时才返回True，否则返回 False。假设两个玩家都以最佳状态参与游戏。
 *
 * 示例 1：
 * 输入：2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 *
 * 示例 2：
 * 输入：3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divisor-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-10-22 23:49
 * @Version 1.0
 **/
public class divisorGame {

    // 归纳法（有规律）
    public boolean divisorGame1(int n) {
        return n % 2 == 0;
    }

    // 动态规划法
    // 定义 f[i] 表示当前数字 i 的时候先手是处于必胜态还是必败态，true 表示先手必胜，false 表示先手必败，
    // 从前往后递推，根据我们上文的分析，枚举 i 在 (0, i) 中 i 的因数 j，看是否存在 f[i-j] 为必败态即可。
    public boolean divisorGame2(int n) {

        boolean[] dp = new boolean[n + 2];
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i <= n ; i++) {
            for (int j = 1; j < i; j++) {
                if ( i % j == 0 && !dp[i - j] ) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

}
