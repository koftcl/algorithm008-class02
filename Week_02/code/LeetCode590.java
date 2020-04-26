import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * N叉树的后序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * 2020/04/26
 */
public class LeetCode590 {
    @Test
    public void name() {

    }

    /**
     * 递归
     * 遍历的时间复杂度是O(N)
     */
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        for (Node child : root.children) {
            ans.addAll(postorder(child));
        }
        ans.add(root.val);
        return ans;
    }

    /**
     * 迭代
     * 遍历的时间复杂度是O(N)
     */
    public List<Integer> postorder1(Node root) {
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
            for (Node child : curr.children) {
                stack.add(child);
            }
        }
        Collections.reverse(ans);
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
    }
}
