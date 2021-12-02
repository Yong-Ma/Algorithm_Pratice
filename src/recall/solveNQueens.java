package recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName solveNQueens
 * @description:
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例 1：
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[["Q"]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-12-02 15:58
 * @Version 1.0
 **/
public class solveNQueens {

    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens1(int n) {
        char[][] nQueen = new char[n][n];
        // 初始化时无皇后
        for (int i = 0; i < n; i++) {
            Arrays.fill(nQueen[i], '.');
        }
        recall(nQueen, n, 0);
        return ans;
    }



    private void recall(char[][] nQueen, int n, int i) {
        if (i == nQueen.length) {
            ans.add(new ArrayList<>(charBinaryArray2Str(nQueen)));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (test(nQueen, i, j)) {
                nQueen[i][j] = 'Q';
                recall(nQueen, n, i + 1);
            }
            nQueen[i][j] = '.';
        }
    }

    /*
     * @Description:
     * 将char二维数组转化为List<String>
     * @Author: mzy
     * @Date: 2021/12/2 17:05
     * @param chars: char二维数组
     * @Return java.util.List<java.lang.String>
     **/
    private List<String> charBinaryArray2Str(char[][] chars) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < chars[i].length; j++) {
                stringBuilder.append(chars[i][j]);
            }
            res.add(stringBuilder.toString());
        }
        return res;
    }
    private boolean test(char[][] nQueen, int row, int col) {

        // 检查同一列
        for (int i = row - 1; i >= 0; i--) {
            if (nQueen[i][col] == 'Q') {
                return false;
            }
        }
        // 检查左斜线位置
        int i = row - 1, j = col - 1;
        while (i >= 0 && j >= 0) {
            if (nQueen[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        // 检查右斜线位置
        int k = row - 1, l = col + 1;
        while (k >= 0 && l < nQueen.length) {
            if (nQueen[k][l] == 'Q') {
                return false;
            }
            k--;
            l++;
        }

        return true;
    }

}

