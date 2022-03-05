package dfs;

import java.util.*;

/**
 * 给你一个有n个节点的 有向无环图（DAG），请你找出所有从节点 0到节点 n-1的路径并输出（不要求按特定顺序）
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
 * 译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yong
 * @date 2021/8/25 21:09
 */
public class allPathsSourceTarget {

    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> stack = new ArrayDeque<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        int n = graph.length - 1;
        stack.offerLast(0);
        dfs(graph, 0 , n);
        return res;
    }

    private void dfs(int[][] graph, int x ,int n) {

        if (x == n) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int y : graph[x]) {
            stack.offerLast(y);
            dfs(graph, y, n);
            stack.pollLast();
        }
    }
}
