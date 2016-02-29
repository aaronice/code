public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
     public int jump(int[] A) {
         if (A == null || A.length == 0) {
             return -1;
         }
         int start = 0, end = 0, jumps = 0;
         while (end < A.length - 1) {
             jumps++;
             int farthest = end;
             for (int i = start; i <= end; i++) {
                 if (A[i] + i > farthest) {
                     farthest = A[i] + i;
                 }
             }
             start = end + 1;
             end = farthest;
         }
         return jumps;
     }

     public static void main(String[] args) {
         Solution s = new Solution();
         int[] A = new int[] {2, 3, 1, 1, 4};
         s.jump(A);
     }
}
