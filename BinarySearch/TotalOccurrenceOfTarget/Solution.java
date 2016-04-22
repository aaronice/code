public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
     public static void main(String[] args) {
         Solution s = new Solution();
         int[] A = {1, 3, 3, 4, 5};
         int target = 3;
         System.out.println(s.totalOccurrence(A, target));

         A = new int[]{2,2,3,4,6};
         target = 4;
         System.out.println(s.totalOccurrence(A, target));

         A = new int[]{};
         target = 10;
         System.out.println(s.totalOccurrence(A, target));


     }
     public int totalOccurrence(int[] A, int target) {
         // O(logN) implementation

         if (A == null || A.length == 0) {
             return 0;
         }

         int[] bound = new int[2];

         int start = 0;
         int end = A.length - 1;

         while (start + 1 < end) {
             int mid = start + (end - start) / 2;
             if (A[mid] >= target) {
                 end = mid;
             } else {
                 start = mid;
             }
         }

         if (A[start] == target) {
             bound[0] = start;
         } else if (A[end] == target) {
             bound[0] = end;
         } else {
             bound[0] = -1;
             return 0;
         }

         start = 0;
         end = A.length - 1;

         while (start + 1 < end) {
             int mid = start + (end - start) / 2;
             if (A[mid] > target) {
                 end = mid;
             } else {
                 start = mid;
             }
         }

         if (A[end] == target) {
             bound[1] = end;
         } else if (A[start] == target) {
             bound[1] = start;
         } else {
             bound[1] = -1;
             return 0;
         }

         int count = bound[1] - bound[0] + 1;

         return count;

     }

}
