

/*
 Approach: Copy the value of the following node, and remove the next node
 */

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }

        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        return;
    }
}
