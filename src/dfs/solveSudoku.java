package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName solveSudoku
 * @description:
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 数独的解法需 遵循如下规则：
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用'.'表示。
 *
 * 示例：
 * 输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * 输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 * 解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
 *

 * 提示：
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字或者 '.'
 * 题目数据 保证 输入数独仅有一个解
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-11-30 22:13
 * @Version 1.0
 **/
public class solveSudoku {

    private boolean[][] rows = new boolean[9][9];
    private boolean[][] cols = new boolean[9][9];
    private boolean[][][] blocks = new boolean[9][9][9];
    // 存储未填数字的位置
    List<int[]> spaces = new ArrayList<>();
    // 是否是合法的数独
    private boolean valid = false;

    public void solveSudoku(char[][] board) {
        // 初始化遍历一遍，填充行列、方块的数字情况
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '1';
                    rows[i][digit] = cols[digit][j] = blocks[i / 3][j / 3][digit] = true;
                }
            }
        }
        dfs(board, 0);
    }

    private void dfs(char[][] board, int position) {
        if (spaces.size() == position) {
            valid = true;
            return;
        }
        int i = spaces.get(position)[0], j = spaces.get(position)[1];
        for (int digit = 0; digit < 9 && !valid; digit++) {
            if (!rows[i][digit] && !cols[digit][j] && !blocks[i / 3][j / 3][digit]) {
                rows[i][digit] = cols[digit][j] = blocks[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '1');
                dfs(board, position + 1);
                rows[i][digit] = cols[digit][j] = blocks[i / 3][j / 3][digit] = false;
            }
        }
    }
}
