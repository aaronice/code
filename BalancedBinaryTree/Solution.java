
// Given a binary tree, determine if it is height-balanced.
//
// For this problem, a height-balanced binary tree is defined as a binary
// tree in which the depth of the two subtrees of every node never differ
// by more than 1.

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
    * @param root: The root of binary tree.
    * @return: True if this Binary tree is Balanced, or false.
    */

    class ResultType {
        TreeNode root;
        int height;
        boolean balanced;

        ResultType(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

    public boolean isBalanced(TreeNode root) {
        // write your code here
        ResultType rs = helper(root);
        return rs.balanced;
    }

    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, true);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        int currentHeight = left.height > right.height ? left.height : right.height;

        if (!left.balanced || !right.balanced) {
            return new ResultType(currentHeight + 1, false);
        }

        if (left.height - right.height > 1 || right.height - left.height > 1) {
            return new ResultType(currentHeight + 1, false);
        }

        return new ResultType(currentHeight + 1, true);

    }
}
