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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> preoder = new ArrayList<Integer>();

        if (root == null) {
            return preoder;
        }

        preoder.addAll(postorderTraversal(root.left));
        preoder.addAll(postorderTraversal(root.right));
        preoder.add(root.val);

        return preoder;
    }
}
