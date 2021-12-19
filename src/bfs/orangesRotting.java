package bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName orangesRotting
 * @description:
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * 值0代表空单元格；
 * 值1代表新鲜橘子；
 * 值2代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回-1。
 *
 * 示例 1：
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 *
 * 示例 2：
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 *
 * 示例 3：
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 *
 * 提示：
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为0、1或2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotting-oranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-12-19 17:00
 * @Version 1.0
 **/
public class orangesRotting {

    public static int orangesRotting(int[][] grid) {
        // 记录需要经过多少次、一开始有多少个好果子
        int count = 0,  goodOranges = 0;
        // 标记坏果子的位置
        ArrayList<int[]> badOranges = new ArrayList<>();
        // 遍历，获取有多少个好果子和坏果子的位置
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    goodOranges++;
                } else if (grid[i][j] == 2) {
                    badOranges.add(new int[]{i, j});
                }
            }
        }

        // 标志遍历一遍是否果子有变坏的
        boolean changeFlag = true;
        while (goodOranges > 0 && changeFlag) {
            changeFlag = false;
            List<int[]> badlists =(List<int[]>) badOranges.clone();
            for (int[] arr : badlists) {
                int i = arr[0], j = arr[1];
                if (grid[i][j] == 2) {
                    // 上
                    if (i - 1 >= 0  && grid[i - 1][j] == 1) {
                        grid[i - 1][j] = 2;
                        badOranges.add(new int[]{i - 1,j});
                        changeFlag = true;
                        goodOranges--;
                    }
                    // 下
                    if (i + 1 < grid.length  && grid[i + 1][j] == 1) {
                        grid[i + 1][j] = 2;
                        badOranges.add(new int[]{i + 1, j});
                        changeFlag = true;
                        goodOranges--;
                    }
                    // 左
                    if (j - 1 >= 0 && grid[i][j -1 ] == 1) {
                        grid[i][j - 1] = 2;
                        badOranges.add(new int[]{i, j - 1});
                        changeFlag = true;
                        goodOranges--;
                    }
                    // 右
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                        grid[i][j + 1] = 2;
                        badOranges.add(new int[]{i, j + 1});
                        changeFlag = true;
                        goodOranges--;
                    }
                }
            }


            if (changeFlag) {
                count++;
            }
        }
        return goodOranges == 0 ? count : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        orangesRotting(grid);
    }
}
