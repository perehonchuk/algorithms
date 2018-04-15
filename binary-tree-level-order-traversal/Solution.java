class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
        }
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, root));
        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            insertToLevel(result, p.level, p.node);
            if (p.node.left != null) {
                queue.add(new Pair(p.level + 1, p.node.left));
            }
            if (p.node.right != null) {
                queue.add(new Pair(p.level + 1, p.node.right));
            }
        }
        return result;
    }

    public void insertToLevel(List<List<Integer>> result, int level, TreeNode node) {
        if (result.size() <= level) {
            result.add(new ArrayList<Integer>());
        }
        List<Integer> l = result.get(level);
        l.add(node.val);
    }

    public static class Pair {
        public int level;
        public TreeNode node;

        public Pair(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }
}
