public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }

        int size = nums.size();
        int min = Integer.MAX_VALUE;
        int sum = 0, maxSum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums.get(i);
            min = Math.min(min, sum - maxSum);
            maxSum = Math.max(sum, maxSum);
        }
        return min;
    }
}
