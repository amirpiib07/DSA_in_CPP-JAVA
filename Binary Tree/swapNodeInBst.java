class Solution {
    TreeNode first = null, second = null, prev = null;

    public void recoverTree(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                detect(curr);
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    detect(curr);
                    curr = curr.right;
                }
            }
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void detect(TreeNode curr) {
        if (prev != null && prev.val > curr.val) {
            if (first == null) first = prev;
            second = curr;
        }
        prev = curr;
    }
}