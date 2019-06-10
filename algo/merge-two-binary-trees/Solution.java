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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 != null) return t2;
        if (t2 == null && t1 != null) return t1;
        if (t1 == null && t2 == null) return null;
        return mergeTrees(t1, t2, new TreeNode(t1.val + t2.val));
    }
    
    TreeNode mergeTrees(TreeNode t1, TreeNode t2, TreeNode result) {
        if (t1 == null & t2 == null) return null;
        TreeNode t1Left = t1 == null? null: t1.left;
        TreeNode t1Right = t1 == null? null: t1.right;
        TreeNode t2Left = t2 == null? null: t2.left;
        TreeNode t2Right = t2 == null? null: t2.right;
        int leftVal = (t1Left == null? 0: t1Left.val) + (t2Left == null? 0: t2Left.val);
        int rightVal = (t1Right == null? 0: t1Right.val) + (t2Right == null? 0: t2Right.val);
        result.left = mergeTrees(t1Left, t2Left, new TreeNode(leftVal));
        result.right = mergeTrees(t1Right, t2Right, new TreeNode(rightVal));
        return result;
    }
}
