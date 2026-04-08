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
    public int ans(TreeNode root){
        if(root == null) return 0;
        
        // if one child is null
        if(root.left == null) return 1 + ans(root.right);
        if(root.right == null) return 1 + ans(root.left);
        
        // both children exist
        return 1 + Math.min(ans(root.left), ans(root.right));
    }
    
    public int minDepth(TreeNode root) {
        return ans(root);
    }
}