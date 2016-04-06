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
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        ListNode p = head;
        ListNode ltDummyHead = new ListNode(0);
        ListNode gtDummyHead = new ListNode(0);
        ListNode lt = ltDummyHead;
        ListNode gt = gtDummyHead;
        while (p != null) {
            if (p.val >= x) {
                gt.next = p;
                gt = gt.next;
            } else {
                lt.next = p;
                lt = lt.next;
            }
            p = p.next;
        }
        gt.next = null;
        lt.next = gtDummyHead.next;
        return ltDummyHead.next;
    }
}
