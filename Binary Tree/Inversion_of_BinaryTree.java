public void mirror(TreeNode root){
        if(root==null) return;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        mirror(root.left);
        mirror(root.right);
    }
    public TreeNode invertTree(TreeNode root) {
        mirror(root);
        return root;
