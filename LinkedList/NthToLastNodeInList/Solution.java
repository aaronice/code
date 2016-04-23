// Find the nth to last element of a singly linked list.
// The minimum number of nodes in list is n.

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
      * @return: Nth to last node of a singly linked list.
      */
     ListNode nthToLast(ListNode head, int n) {
         if (head == null || n == 0) {
             return head;
         }

         ListNode p = head;
         // IDEA: to make p node is Nth to head node
         for (int i = 0; i < n - 1; i++) {
             head = head.next;
         }

         // IDEA: when head node is the last, p node will be Nth to the last
         while (head.next != null) {
             head = head.next;
             p = p.next;
         }

         return p;
     }
 }
