import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 2020/04/26
 */
public class LeetCode144 {
    @Test
    public void name() {
        TreeNode root = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        root.right = a1;
        TreeNode a2 = new TreeNode(3);
        root.left = a2;
        for (Integer integer : preorderTraversal1(root)) {
            System.out.println(integer);
        }

    }

    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        LinkedList<Integer> list1 = new LinkedList<>(list);
        while (!list1.isEmpty()) {
            System.out.println(list1.removeLast());
        }
    }

    /**
     * 递归
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        ans.add(root.val);
        ans.addAll(preorderTraversal(root.left));
        ans.addAll(preorderTraversal(root.right));
        return ans;
    }

    /**
     * 迭代
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pollLast();
            ans.add(curr.val);
            if (curr.right != null) {
                stack.add(curr.right);
            }
            if (curr.left != null) {
                stack.add(curr.left);
            }

        }

        return ans;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
