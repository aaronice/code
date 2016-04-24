public class Solution {
    /**
     * @param nums: A list of integers
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
}
