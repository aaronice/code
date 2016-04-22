

/**
 * Given a binary tree, find the maximum path sum from root.
 * The path may end at any node in the tree and contain at least one node in it.
 * The Node value can be negative
 */

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree.
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        // Write your code here
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int leftMaxPathSum = maxPathSum2(root.left);
        int rightMaxPathSum = maxPathSum2(root.right);

        return (Math.max(Math.max(leftMaxPathSum, rightMaxPathSum), 0) + root.val);
    }
}
