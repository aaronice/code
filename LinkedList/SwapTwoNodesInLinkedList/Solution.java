/**
 *  Given a linked list and two values v1 and v2. Swap the two nodes in the
 *  linked list with values v1 and v2. It's guaranteed there is no duplicate
 *  values in the linked list. If v1 or v2 does not exist in the given
 *  linked list, do nothing.
 */


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
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        if (head == null || v1 == v2) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        ListNode prev1 = head, next1 = head, n1 = head, prev2 = head, next2 = head, n2 = head;
        Boolean hasV1 = false, hasV2 = false;

        while (head.next != null) {
            if (head.next.val == v1) {
                n1 = head.next;
                prev1 = head;
                next1 = head.next.next;
                hasV1 = true;
            }
            if (head.next.val == v2) {
                n2 = head.next;
                prev2 = head;
                next2 = head.next.next;
                hasV2 = true;
            }
            head = head.next;
        }

        if (hasV1 && hasV2) {
            if (prev1.val == v2) {
                prev2.next = n1;
                n1.next = n2;
                n2.next = next1;
            } else if (prev2.val == v1) {
                prev1.next = n2;
                n2.next = n1;
                n1.next = next2;
            } else {
                prev1.next = n2;
                n2.next = next1;
                prev2.next = n1;
                n1.next = next2;
            }
        }

        return dummy.next;
    }
}
