import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 2020/05/02
 */
public class LeetCode105 {

    @Test
    public void name() {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    private int[] preOrder;
    int pre = 0;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    /**
     * 递归
     * T O(logn)
     * S O(n)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        this.preOrder = preorder;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return dfs(0, inorder.length);
    }

    private TreeNode dfs(int start, int end) {
        if (start == end) return null;
        int val = preOrder[pre];
        TreeNode node = new TreeNode(val);

        int index = map.get(val);

        pre++;
        node.left = dfs(start, index);
        node.right = dfs(index + 1, end);

        return node;
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
