package binaryTree;

import java.util.List;

/**
 * @ClassName Node
 * @description:
 * Definition for a Node.
 * @author: mzy
 * @create: 2021-11-21 16:30
 * @Version 1.0
 **/
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
