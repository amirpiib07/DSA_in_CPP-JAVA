class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;

        }
    }

    public List<List<Integer>> zig(TreeNode root, List<List<Integer>> ans) {
        
        Queue<Pair> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        q.add(new Pair(root, 0));
        int currlevel = 0;
        while (q.size() != 0) {
            Pair front = q.remove();
            if (currlevel != front.level) {
                currlevel = front.level;
                ans.add(new ArrayList<>(list));
                list.clear();
            }
            if (currlevel % 2 == 0) {
                if(front.node!=null)list.add(front.node.val);           // normal order
            } else {
                if(front.node!=null)list.add(0, front.node.val);        // reverse order
            }
            
            if (front.node != null && front.node.left != null )
                q.add(new Pair(front.node.left, front.level + 1));
            if (front.node != null && front.node.right != null )
                q.add(new Pair(front.node.right, front.level + 1));
        }
        if (!list.isEmpty()) {
            ans.add(list);
        }

        return ans;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        return zig(root, ans);
    }
