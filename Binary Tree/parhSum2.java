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
    public List<List<Integer>> path(List<List<Integer>> ans, List<Integer> arr, TreeNode root, int target) {
        if (root == null) return ans;

        arr.add(root.val);

        if (root.left == null && root.right == null && target == root.val) {
            ans.add(new ArrayList<>(arr));
        }

        path(ans, arr, root.left, target - root.val);
        path(ans, arr, root.right, target - root.val);

        arr.remove(arr.size() - 1);
        return ans;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        return path(ans, new ArrayList<>(), root, targetSum);
    }
}