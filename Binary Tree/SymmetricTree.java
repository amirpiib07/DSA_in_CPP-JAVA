void mirror(TreeNode root){
        if(root==null) return;
        TreeNode temp= root.left;
        root.left=root.right;
        root.right=temp;
        mirror(root.left);
        mirror(root.right);
    }
    public boolean isSame(TreeNode p, TreeNode q){
        if(p==null&&q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;
        return isSame(p.left,q.left) && isSame(p.right,q.right);
    }
    public boolean isSymmetric(TreeNode root) {
        mirror(root.left);
        return isSame(root.left,root.right);
    }
