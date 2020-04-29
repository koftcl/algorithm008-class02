import org.junit.Test;

import java.util.LinkedList;

public class LeetCode297 {
    @Test
    public void name() {

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        int size = 1, empty = 0;
        TreeNode[] pre = new TreeNode[size];
        pre[0] = root;

        while (empty != size) {
            empty = 0;
            TreeNode[] curr = new TreeNode[size * 2];
            for (int i = 0; i < size; i++) {
                TreeNode node = pre[i];
                builder.append(node.val).append(',');

                curr[i] = node.left;
                curr[i + 1] = node.right;

                if (node.left == null) empty++;
                if (node.right == null) empty++;
            }
            pre = curr;
        }
        return builder.substring(0, builder.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");

        for (int i = 0; i < nodes.length; i++) {

        }
        return null;
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
