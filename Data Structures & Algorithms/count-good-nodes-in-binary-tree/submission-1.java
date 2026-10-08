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
    public int goodNodes(TreeNode root) {
        return f(root.val, root);
    }

    public int f(int max, TreeNode node) {
        if(node == null) return 0;

        int res;
        if(node.val >= max) {
            res = 1;
        } else {
            res = 0;
        }

        max = Math.max(max, node.val);
        res += f(max, node.left);
        res += f(max, node.right);
        return res;

    }
}
