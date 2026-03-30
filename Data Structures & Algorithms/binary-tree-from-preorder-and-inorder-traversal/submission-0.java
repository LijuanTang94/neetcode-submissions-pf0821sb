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
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;
        map = new HashMap<>();
        int n = inorder.length;
        for(int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, n - 1, inorder, 0, n - 1);
    }
    private TreeNode build(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if (prestart > preend) return null;
        int rootVal = preorder[prestart];
        int idx = map.get(rootVal);
        int leftLength = idx - instart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, prestart + 1, prestart + leftLength, inorder, instart, idx - 1);
        root.right = build(preorder, prestart + leftLength + 1, preend, inorder, idx + 1, inend);
        return root;
    }
}
