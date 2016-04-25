/*
Given an array of integers, find a contiguous subarray which has the largest sum.

Example

Given the array `[−2,2,−3,4,−1,2,1,−5,3]`, the contiguous subarray `[4,−1,2,1]` has the largest sum = `6`.
*/

public class Solution {
    // Version 1: Greedy
    /**
     * @param nums: An array of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum = sum + nums[i];
            max = Math.max(sum, max);
            sum = Math.max(sum, 0);
        }
        return max;
    }


    // Version 2: Prefix Sum (DP)
    public int maxSubArrayDP(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }

        return max;
    }
}
