class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root != null) {
            levelOrderBottom(root, 0, result);
        }
        return result;
    }

    private void levelOrderBottom(TreeNode node, int level, LinkedList<List<Integer>> result) {
        List<Integer> l = getByLevel(result, level);
        l.add(node.val);
        if (node.left != null) {
            levelOrderBottom(node.left, level + 1, result);
        }
        if (node.right != null) {
            levelOrderBottom(node.right, level + 1, result);
        }
    }

    private List<Integer> getByLevel(LinkedList<List<Integer>> result, int level) {
        if (level >= result.size()) {
            result.addFirst(new ArrayList<Integer>());
        }
        return result.get(result.size() - level - 1);
    }
}
