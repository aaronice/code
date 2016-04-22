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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode lastNode = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }

        if (l1 != null) {
            lastNode.next = l1;
        } else {
            lastNode.next = l2;
        }

        return dummy.next;
    }
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKListsNaive(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        if (lists.size() == 1) {
            return lists.get(0);
        }

        int listSize = lists.size();

        ListNode base = lists.get(0);

        for (int i = 1; i < listSize; i++) {
            base = mergeTwoLists(base, lists.get(i));
        }
        return base;
    }
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
     public ListNode mergeKLists(List<ListNode> lists) {
         if (lists.size() == 0) {
             return null;
         }
         if (lists.size() == 1) {
             return lists.get(0);
         }
         if (lists.size() == 2) {
             return mergeTwoLists(lists.get(0), lists.get(1));
         }
         return mergeTwoLists(mergeKLists(lists.subList(0, lists.size()/2)),
         mergeKLists(lists.subList(lists.size()/2, lists.size())));
     }
}
