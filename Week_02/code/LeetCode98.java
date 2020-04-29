import org.junit.Test;

public class LeetCode98 {
    @Test
    public void name() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        TreeNode a1 = new TreeNode(15);
        root.right = a1;
        a1.left = new TreeNode(6);
        a1.right = new TreeNode(20);
        System.out.println(isValidBST(root));
    }

    /**
     * 中序遍历
     */
    public boolean isValidBST(TreeNode root) {
        helper(root);
        return valid;
    }

    Integer pre = null;
    boolean valid = true;

    private void helper(TreeNode node) {
        if (!valid || node == null) return;

        helper(node.left);
        if (!valid) return;
        if (pre != null) valid = pre < node.val;
        if (!valid) return;
        pre = node.val;
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
