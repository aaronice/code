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
// Version 2: Divide & Conquer
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> preoder = new ArrayList<Integer>();

        if (root == null) {
            return preoder;
        }

        preoder.add(root.val);
        preoder.addAll(preorderTraversal(root.left));
        preoder.addAll(preorderTraversal(root.right));

        return preoder;
    }
}


// Version 0: Non-Recursion (Recommend)

// public class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         Stack<TreeNode> stack = new Stack<TreeNode>();
//         List<Integer> preorder = new ArrayList<Integer>();
//
//         if (root == null) {
//             return preorder;
//         }
//
//         stack.push(root);
//         while (!stack.empty()) {
//             TreeNode node = stack.pop();
//             preorder.add(node.val);
//             if (node.right != null) {
//                 stack.push(node.right);
//             }
//             if (node.left != null) {
//                 stack.push(node.left);
//             }
//         }
//
//         return preorder;
//     }
// }
