class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;
        TreeNode l=root.left;
        TreeNode r=root.right;
        flatten(l);flatten(r);
        root.left=null;
        root.right=l;
        TreeNode help=root;
        while(help.right!=null) help=help.right;
        help.right=r;
    }
}