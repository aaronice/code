public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        // O(n) implementation
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                count++;
            }
        }
        return count;
    }


}
