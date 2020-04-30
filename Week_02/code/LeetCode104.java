import org.junit.Test;

import java.util.LinkedList;

/**
 * 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 2020/04/24
 * 2020/04/30 使用递归刷一遍
 */
public class LeetCode104 {
    @Test
    public void name() {

    }

    /**
     * 递归
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return Math.max(left, right);
    }

    /**
     * 迭代
     * 考虑用pair保存深度信息
     * 需要维护栈，因此比递归慢
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        int maxLevel = 1;
        LinkedList<TreeNode> stack = new LinkedList<>();
        root.val = 1;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.left != null) {
                curr.left.val = curr.val + 1;
                stack.push(curr.left);
            }
            if (curr.right != null) {
                curr.right.val = curr.val + 1;
                stack.push(curr.right);
            }
            if (curr.right != null || curr.left != null) {
                maxLevel = Math.max(curr.val + 1, maxLevel);
            }
        }
        return maxLevel;
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
