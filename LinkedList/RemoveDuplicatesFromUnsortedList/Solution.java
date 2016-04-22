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
     * @param head: The first node of linked list.
     * @return: head node
     */
    public ListNode removeDuplicates(ListNode head) {
        // Write your code here
        Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p != null && p.next != null) {
            if (hashmap.containsKay(new Integer(p.next.val))) {
                p.next = p.next.next;
            } else {
                hashmap.put(p.next.val, 1);
                p = p.next;
            }
        }
        return dummy.next;
    }
}
