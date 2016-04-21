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
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int length = getLength(head);
        int n = k % length;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode tail = dummy;

        for (int i = 0; i < n; i++) {
            head = head.next;
        }

        while (head.next != null) {
            head = head.next;
            tail = tail.next;
        }

        head.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;

        return dummy.next;
    }
}
