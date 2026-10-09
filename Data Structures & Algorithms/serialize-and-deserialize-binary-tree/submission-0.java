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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //if(root == null) return "";

        ArrayList<String> arr = new ArrayList<>();

        dfs(root, arr);

        StringBuilder sb = new StringBuilder();

        for(String s : arr) {
            sb.append(s);
            sb.append(",");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    private static void dfs(TreeNode node, ArrayList<String> arr) {
        if(node == null) {
            arr.add("#");
            return;
        }
        arr.add(Integer.toString(node.val));
        dfs(node.left, arr);
        dfs(node.right, arr);
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] i = {0};
        return dfs2(vals, i);
    }

    private TreeNode dfs2(String[] vals, int[] i) {
        if(vals[i[0]].equals("#")) {
            i[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;
        node.left = dfs2(vals, i);
        node.right = dfs2(vals, i);
        return node;
    }
}
