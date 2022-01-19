package dfs;

/**
 * @ClassName Exist
 * @description:
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 * 示例 2：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 *
 * 示例 3：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2022-01-16 17:04
 * @Version 1.0
 **/
public class Exist {

    private static boolean ans = false;
    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] flag = new boolean[m][n];
                dfs(board, i, j, word, 0, flag);
                if (ans) {
                    return true;
                }

            }
        }
        return false;
    }
    private static void dfs(char[][] board, int i, int j, String word, int target, boolean[][] flag) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || flag[i][j] || board[i][j] != word.charAt(target)) {
            return ;
        }
        if (target == word.length() - 1 ) {
            ans = true;
            return;
        }
        flag[i][j] = true;
        dfs(board, i, j + 1, word, target + 1, flag);
        dfs(board, i, j - 1, word, target + 1, flag);
        dfs(board, i - 1, j, word, target + 1, flag);
        dfs(board, i + 1, j, word, target + 1, flag);
        flag[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},
                {'S','F','E','S'},{'A','D','E','E'}};
        exist(board,"ABCESEEEFS");
    }
}
