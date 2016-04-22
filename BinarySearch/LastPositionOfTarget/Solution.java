public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */

     public static void main(String[] args) {
         Solution s = new Solution();
         int[] A = {1, 2, 3, 3, 4, 5, 10};
         int target = 3;
         System.out.println("first position of index: " + s.lastPosition(A, target));
     }


    public int lastPosition(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int start  = 0;
        int end = A.length - 1;
        int mid;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (A[end] == target) {
            return end;
        }

        if (A[start] == target) {
            return start;
        }

        return -1;
    }
}
