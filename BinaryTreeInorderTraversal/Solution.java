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
// public class Solution {
//     /**
//     * @param root: The root of binary tree.
//     * @return: Inorder in ArrayList which contains node values.
//     */
//     public ArrayList<Integer> inorderTraversal(TreeNode root) {
//         // write your code here
//         ArrayList<Integer> inoder = new ArrayList<Integer>();
//
//         if (root == null) {
//             return inoder;
//         }
//
//         inoder.addAll(inorderTraversal(root.left));
//         inoder.add(root.val);
//         inoder.addAll(inorderTraversal(root.right));
//
//         return inoder;
//     }
// }

// Version 2: Non-Recursion
public class Solution {
    /**
    * @param root: The root of binary tree.
    * @return: Inorder in ArrayList which contains node values.
    */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if (root == null) {
            return inorder;
        }

        // pointer to track current node
        TreeNode pointer = root;

        while (!stack.isEmpty() || pointer != null) {

            if (pointer != null) {
                // If not null, push to stack and go down to the left
                stack.push(pointer);
                pointer = pointer.left;

            } else {
                // If null, time to pop stack, and go down to the right
                TreeNode node = stack.pop();
                inorder.add(node.val);
                pointer = node.right;
            }
        }

        return inorder;
    }
}
