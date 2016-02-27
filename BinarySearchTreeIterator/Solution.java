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
* Example of iterate a tree:
* BSTIterator iterator = new BSTIterator(root);
* while (iterator.hasNext()) {
*    TreeNode node = iterator.next();
*    do something for node
* }
*/

public class BSTIterator {

    private ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
    private int pointer;
    private int length;

    //@param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        // write your code here
        this.nodes = inorderTraversal(root);
        if (nodes.size() > 0) {
            this.pointer = 0;
            this.length = this.nodes.size();
        }
    }

    private static ArrayList<TreeNode> inorderTraversal(TreeNode root) {
        ArrayList<TreeNode> inorder = new ArrayList<TreeNode>();

        if (root == null) {
            return inorder;
        }

        inorder.addAll(inorderTraversal(root.left));
        inorder.add(root);
        inorder.addAll(inorderTraversal(root.right));

        return inorder;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        if (this.pointer < this.length) {
            return true;
        } else {
            return false;
        }
    }

    //@return: return next node
    public TreeNode next() {
        // write your code here
        if (this.pointer < length) {
            this.pointer += 1;
            return this.nodes.get(pointer - 1);
        } else {
            return null;
        }

    }
}
