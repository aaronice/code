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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        int capacity = hashTable.length;
        int newCapacity = 2 * capacity;
        ListNode[] newHashTable = new ListNode[newCapacity];
        for (int i = 0; i < capacity; i++) {
            ListNode ln = hashTable[i];
            while (ln != null) {
                int code = hashcode(ln.val, newCapacity);
                insertToHashTable(newHashTable, code, ln.val);
                ln = ln.next;
            }
        }
        return newHashTable;
    }
    public int hashcode(int key, int capacity) {
        int hash;
        if (key < 0) {
            hash = (key % capacity + capacity) % capacity;
        } else {
            hash = key % capacity;
        }
        // System.out.println("hashcode: " + hash);
        return hash;
    }
    private void insertToHashTable(ListNode[] hashTable, int code, int value) {
        if (code < hashTable.length) {
            ListNode ln = hashTable[code];
            if (ln == null) {
                hashTable[code] = ln = new ListNode(value);
                // System.out.println("Here: " + value);
            } else {
                while (ln.next != null) {
                    ln = ln.next;
                }
                ln.next = new ListNode(value);
                // System.out.println("Here: " + value);
            }
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode[] lsn = new ListNode[3];
        lsn[0] = null;
        lsn[1] = null;
        lsn[2] = new ListNode(29);
        lsn[2].next = new ListNode(5);
        ListNode[] newLsn = s.rehashing(lsn);
    }
};

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
