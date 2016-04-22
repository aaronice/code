/**
 * Definition for singly-linked list.
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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode pointer = head;

        int carry = 0;

        while (l1 != null && l2 != null) {

            int sum = l1.val + l2.val + carry;
            carry = sum / 10;

            pointer.next = new ListNode(sum % 10);
            pointer = pointer.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            pointer.next = new ListNode(sum % 10);
            pointer = pointer.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            pointer.next = new ListNode(sum = sum % 10);
            pointer = pointer.next;
            l2 = l2.next;
        }

        if (carry != 0) {
            pointer.next = new ListNode(carry);
        }

        return head.next;
    }

}
