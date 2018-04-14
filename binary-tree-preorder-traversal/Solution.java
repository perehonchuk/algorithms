class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pollFirst();
            result.add(node.val);
            if (node.right != null) {
                stack.addFirst(node.right);
            }
            if (node.left != null) {
                stack.addFirst(node.left);
            }
        }
        return result;
    }
}
