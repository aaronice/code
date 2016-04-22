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
     * @param n: An integer.
     * @return: The head of linked list.
     */
    // Solution 1: Naive implementation
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode pointer = dummyNode;
        int counter = 0;
        while(pointer.next != null) {
            pointer = pointer.next;
            counter++;
        }

        int length = counter;
        if (n > length) {
            return null;
        }
        pointer = dummyNode;
        for (int i = 0; i < length - n; i++) {
            pointer = pointer.next;
        }
        pointer.next = pointer.next.next;
        return dummyNode.next;
    }

    // Solution 2: Two pointers, slow and fast
    public ListNode removeNthFromEnd2(ListNode head, int n) {
       ListNode dummyHead = new ListNode(0);
       dummyHead.next = head;
       ListNode p = dummyHead;
       ListNode runner = dummyHead;
       while(n > 0){
           runner = runner.next;
           n--;
       }
       while(runner.next!=null){
           runner = runner.next;
           p = p.next;
       }
       p.next = p.next.next;
       return dummyHead.next;
    }
}
