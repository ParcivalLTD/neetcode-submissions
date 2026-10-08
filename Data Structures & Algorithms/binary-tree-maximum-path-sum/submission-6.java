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
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        //res = root.val;
        int val = dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if(node == null) return 0;

        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        int localPath = node.val + left + right;

        res = Math.max(res, localPath);
        int tmp = Math.max(left, right);
        tmp = Math.max(tmp, 0);
        return node.val + tmp;
    }
}
