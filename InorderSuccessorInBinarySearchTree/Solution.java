/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {


    private void dfs(TreeNode root, TreeNode p, boolean flag, TreeNode successor) {
        if (root == null) {
            return;
        }
        if (flag == true) {
            successor = root;
        }
        if (root.val == p.val) {
            flag = true;
        } else {
            flag = false;
        }
        dfs(root.left, p, flag, successor);
        dfs(root, p, flag, successor);
        dfs(root.right, p, flag, successor);

    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here

        TreeNode successor = new TreeNode(0);
        dfs(root, p, false, successor);
        return successor;
    }
}
