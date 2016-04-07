/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public ListNode middleNode(ListNode head) {
        // Write your code here
        ListNode pF = head;
        ListNode pS = head;
        while (pF != null && pF.next != null && pF.next.next != null) {
            pF = pF.next.next;
            pS = pS.next;
        }
        return pS;
    }
}
