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
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        // 0 not rob 1 rob
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int res1 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int res2 = root.val + left[0] + right[0];
        return new int[]{res1, res2};
    }
}