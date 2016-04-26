/*
Given an array of integers, find two non-overlapping subarrays which have the largest sum.
The number in each subarray should be contiguous.
Return the largest sum.
*/

public class Solution {
    /**
    * @param nums: A list of integers
    * @return: An integer denotes the sum of max two non-overlapping subarrays
    */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        int size = nums.size();
        int[] left = new int[size];
        int[] right = new int[size];
        int sum = 0;
        int minSum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            left[i] = max;
        }

        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        for (int i = size - 1; i > 0; i--) {
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            right[i] = max;
        }
        max = Integer.MIN_VALUE;
        for (int i = 0; i < size - 1; i++) {
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;
    }
}
