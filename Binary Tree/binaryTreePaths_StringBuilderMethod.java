void dfs(TreeNode root, List<Integer> path ,List<String> result){
        if(root==null) return;
        path.add(root.val);
        if(root.left==null && root.right==null){
            StringBuilder sb= new StringBuilder();
            for(int i=0; i<path.size(); i++){
                sb.append(path.get(i));
                if(i!=path.size()-1) sb.append("->");
            }
            result.add(sb.toString());
        }
        else{
        dfs(root.left, path, result);
        dfs(root.right,path,result);
        }

        path.remove(path.size()-1);
        
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans= new ArrayList<>();
        if(root==null) return ans;
        dfs(root,new ArrayList<>(), ans); 
        return ans;
    }
