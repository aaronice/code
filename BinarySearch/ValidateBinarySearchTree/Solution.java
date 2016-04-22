/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 *  The left subtree of a node contains only nodes with keys less than the node's key.
 *  The right subtree of a node contains only nodes with keys greater than the node's key.
 *  Both the left and right subtrees must also be binary search trees.
 *  A single node tree is a BST
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

 // Solution 1: Traverse

 public class Solution {
     /**
      * @param root: The root of binary tree.
      * @return: True if the binary tree is BST, or false
      */
     private int lastVal = Integer.MIN_VALUE;
     private boolean firstNode = true;
     public boolean isValidBST(TreeNode root) {
         if (root == null) {
             return true;
         }
         if (!isValidBST(root.left)) {
             return false;
         }
         if (!firstNode && lastVal >= root.val) {
             return false;
         }
         firstNode = false;
         lastVal = root.val;

         System.out.println("lastVal" + lastVal);

         if (!isValidBST(root.right)) {
             return false;
         }
         return true;
     }
 }

 class ResultType {
    boolean is_bst;
    int maxValue, minValue;

    ResultType(boolean is_bst, int maxValue, int minValue) {
        this.is_bst = is_bst;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
}


// Solution 2 Divide and Conquer
// https://en.wikipedia.org/wiki/Binary_search_tree
// http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
// http://www.cnblogs.com/yuzhangcmu/p/4177047.html

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        if (validateHelper(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
            return true;
        } else {
            return false;
        }
    }

    // long type for minValue, maxValue
    private boolean validateHelper(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }

        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }

        return validateHelper(root.left, minValue, root.val) && validateHelper(root.right, root.val, maxValue);
    }

}
