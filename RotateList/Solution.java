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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode pointer = head;
        ListNode tail = new ListNode(0);
        tail.next = head;
        int length = 0;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        if (length == 0) {
            return head;
        } else {
            k = k % length;
        }
        int off = length - k;

        pointer = head;
        while (off > 0) {
            pointer = pointer.next;
            off--;
        }
        ListNode dummy = new ListNode(0);

        dummy.next = pointer;

        tail.next = head;

        return dummy.next;
    }
}
