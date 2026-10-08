/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        height(root);

        return balanced;
    }

    private int height(TreeNode curr) {
        if(curr == null) return 0;

        int lHeight = height(curr.left);
        int rHeight = height(curr.right);

        if(lHeight + 1 != rHeight && rHeight + 1 != lHeight && rHeight != lHeight) balanced = false;

        return 1 + Math.max(lHeight, rHeight);
    }
}
