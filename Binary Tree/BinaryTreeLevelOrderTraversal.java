
    class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrderTraversal(TreeNode root, List<List<Integer>> ans) {
        Queue<Pair> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        q.add(new Pair(root, 0));
        int currLevel = 0;
        while (q.size() > 0) {
            Pair front = q.remove();
            if (front.level != currLevel) {
                currLevel = front.level;
                ans.add(new ArrayList<>(list));
                list.clear();
            }
            if (front.node != null)
                list.add(front.node.val);
            if (front.node != null && front.node.left != null)
                q.add(new Pair(front.node.left, front.level + 1));
            if (front.node != null && front.node.right != null)
                q.add(new Pair(front.node.right, front.level + 1));

        }
        if (!list.isEmpty())
            ans.add(new ArrayList<>(list));

        return ans;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        return levelOrderTraversal(root, ans);
    }
