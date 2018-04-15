/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);
        TreeNode n = root;
        while(!stack.isEmpty() || n != null) {
            while(n != null && n.left != null) {
                stack.addFirst(n.left);
                n = n.left;
            }
            TreeNode node = stack.pollFirst();
            result.add(node.val);
            n = node.right;
            if (n != null) {
                stack.addFirst(n);    
            }
        }
        return result;
    }
}
