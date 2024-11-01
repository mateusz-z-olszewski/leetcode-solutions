package leetcode.editor.en;

class DiameterOfBinaryTree {

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        calculateDepth(root);
        return diameter;
    }

    /**
     * Calculate the depth of the node, and also update the max diameter.
     * @return depth of the tree.
     */
    public int calculateDepth(TreeNode root) {
        if(root.left == null && root.right == null) return 0;
        if(root.left == null || root.right == null) {
            TreeNode child = root.left != null ? root.left : root.right;
            int depth = calculateDepth(child);
            diameter = Math.max(diameter, depth + 1);
            return depth + 1;
        }
        int leftDepth = calculateDepth(root.left);
        int rightDepth = calculateDepth(root.right);
        diameter = Math.max(diameter, leftDepth + rightDepth + 2);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}