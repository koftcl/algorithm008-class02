import org.junit.Test;

import java.util.LinkedList;

public class LeetCode297 {
    @Test
    public void test1() {
        TreeNode node = deserialize("[]");
        System.out.println(serialize(node));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        int size = 1, empty = 0;
        TreeNode[] pre = new TreeNode[size];
        pre[0] = root;

        while (empty != size) {
            empty = 0;
            TreeNode[] curr = new TreeNode[size * 2];
            for (int i = 0; i < size; i++) {
                TreeNode node = pre[i];
                if (node == null) {
                    builder.append("null").append(',');
                    curr[i * 2] = null;
                    curr[i * 2 + 1] = null;
                    empty += 2;
                } else {
                    builder.append(node.val).append(',');
                    curr[i * 2] = node.left;
                    curr[i * 2 + 1] = node.right;
                    if (node.left == null) empty++;
                    if (node.right == null) empty++;
                }


            }
            size *= 2;
            pre = curr;
        }
        return builder.substring(0, builder.length() - 1) + "]";
    }

    @Test
    public void test2() {
        TreeNode node = deserialize("[1,2,3,null,null,4,5]");
        System.out.println(node);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() < 3) {
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] nodes = data.split(",");
        TreeNode root= new TreeNode(Integer.parseInt(nodes[0]));
        helper(root, 0, nodes);

        return root;
    }

    private void helper(TreeNode node, int i, String[] nodes) {
        // terminator
        if (i > nodes.length) return;

        // drill down
        TreeNode left = child(nodes, i, 1);
        if (left != null) {
            node.left = left;
            helper(left, i * 2 + 1, nodes);
        }
        TreeNode right = child(nodes, i, 2);
        if (right != null) {
            node.right = right;
            helper(right, i * 2 + 2, nodes);
        }
    }

    private TreeNode child(String[] nodes, int i, int index) {
        if (i * 2 + 1 >= nodes.length) return null;
        String node = nodes[2 * i + index];
        if ("null".equals(node)) {
            return null;
        }
        return new TreeNode(Integer.parseInt(node));
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
