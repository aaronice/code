// Given an array of non-negative integers,
// you are initially positioned at the first index of the array.
//
// Each element in the array represents
// your maximum jump length at that position.
//
// Determine if you are able to reach the last index.


// Greedy algorithm
public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
     public boolean canJump(int[] A) {
         // think it as merging n intervals
         if (A == null || A.length == 0) {
             return false;
         }
         int farthest = A[0];
         for (int i = 1; i < A.length; i++) {
             if (i <= farthest && A[i] + i >= farthest) {
                 farthest = A[i] + i;
             }
         }
         return farthest >= A.length - 1;
     }
}

// version 2: Dynamic Programming
// public class Solution {
//     public boolean canJump(int[] A) {
//         boolean[] can = new boolean[A.length];
//         can[0] = true;
//
//         for (int i = 1; i < A.length; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (can[j] && j + A[j] >= i) {
//                     can[i] = true;
//                     break;
//                 }
//             }
//         }
//
//         return can[A.length - 1];
//     }
// }
