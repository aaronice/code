/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;

        ListNode temp1 = pointer;
        ListNode temp2 = pointer;

        while (pointer.next != null && pointer.next.next != null) {
            temp1 = pointer.next;
            temp2 = pointer.next.next.next;

            // pointer -> n1 -> n2 -> n3 -> ...
            // => pointer -> n2 -> n1 -> n3 ...
            pointer.next = temp1.next;
            pointer.next.next = temp1;
            temp1.next = temp2;
            pointer = pointer.next.next;
        }

        return dummy.next;
    }
}
