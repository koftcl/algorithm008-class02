import org.junit.Test;

import java.util.LinkedList;

/**
 * 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/submissions/
 * 2020/04/29
 */
public class LeetCode111 {
    @Test
    public void name() {

    }

    /**
     * 迭代
     */
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> pre = new LinkedList<>();
        pre.add(root);
        int level = 0;

        while (!pre.isEmpty()) {
            level++;
            LinkedList<TreeNode> curr = new LinkedList<>();
            for (TreeNode node : pre) {
                if (node.left == null && node.right == null) return level;
                if (node.left != null) curr.add(node.left);
                if (node.right != null) curr.add(node.right);
            }
            pre = curr;
        }
        return level;
    }

    /**
     * 递归
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left, right) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
