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
    int idx;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serial(root, sb);
        return sb.toString();
    }
    private void serial(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(String.valueOf(root.val)).append(",");
        serial(root.left, sb);
        serial(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] d = data.split(",");
        idx = 0;
        return deserial(d);
    }
    private TreeNode deserial(String[] d) {
        if (d[idx].equals("null")) {
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(d[idx]));
        idx++;
        root.left = deserial(d);
        root.right = deserial(d);
        return root;
    }
}
