import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * N叉树的层序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * 2020/04/26
 */
public class LeetCode429 {
    @Test
    public void name() {

    }

    /**
     * 按层迭代
     */
    public List<List<Integer>> levelOrder(Node root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        LinkedList<Node> curr;
        LinkedList<Node> next = new LinkedList<>();
        next.add(root);

        while (!next.isEmpty()) {
            curr = next;
            next = new LinkedList<>();
            LinkedList<Integer> list = new LinkedList<>();
            for (Node node : curr) {
                list.add(node.val);
                next.addAll(node.children);
            }
            ans.add(list);
        }
        return ans;
    }

    static class Node {
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
}
