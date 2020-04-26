import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * N叉树的前序遍历 DFS
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * 2020/04/26
 */
public class LeetCode589 {
    @Test
    public void name() {
    }

    /**
     * 递归
     * 遍历的时间复杂度是O(N)
     */
    public List<Integer> preorder(Node root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        ans.add(root.val);
        for (Node child : root.children) {
            ans.addAll(preorder(child));
        }
        return ans;
    }

    /**
     * 迭代
     * 遍历的时间复杂度是O(N)
     */
    public List<Integer> preorder1(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            // 注意 pop 与 pollLast 的区别
            Node curr = stack.pollLast();
            ans.add(curr.val);
            Collections.reverse(curr.children);
            for (Node child : curr.children) {
                stack.add(child);
            }
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
