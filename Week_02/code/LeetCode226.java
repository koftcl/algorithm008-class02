import org.junit.Test;

/**
 * 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/description/
 * 2020/04/29
 */
public class LeetCode226 {
    @Test
    public void name() {

    }

    /**
     * 递归
     */
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode node) {
        // terminator
        if (node == null) return;

        // process
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        // drill down
        helper(node.left);
        helper(node.right);

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
