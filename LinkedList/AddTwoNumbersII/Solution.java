/**
 * You have two numbers represented by a linked list, where each node contains
 * a single digit. The digits are stored in forward order, such that the 1's
 * digit is at the head of the list. Write a function that adds the two numbers
 * and returns the sum as a linked list.
 *
 * Example
 * Given 6->1->7 + 2->9->5. That is, 617 + 295.
 * Return 9->1->2. That is, 912.
 */

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
    // head -> n1 -> n2 -> null
    // dummy -> null
    // dummy -> n1 -> null
    // dummy -> n2 -> n1 -> null
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);

        while (head != null) {
            ListNode rTemp = dummy.next;
            ListNode fTemp = head.next;
            dummy.next = head;
            dummy.next.next = rTemp;
            head = fTemp;
        }
        return dummy.next;
    }

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
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        return reverse(addLists(l1, l2));
    }
}
