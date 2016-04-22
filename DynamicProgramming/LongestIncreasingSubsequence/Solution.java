public class Solution {
    /**
     * Solution 1: Dynamic Programming, O(n^2)
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxLength = 1;

        // T[i] the longest increasing subsequence at [i]
        int[] T = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            T[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j] && T[i] < T[j] + 1) {
                    T[i] = T[j] + 1;
                }
            }
            if (T[i] > maxLength) {
                maxLength = T[i];
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result;
        int[] nums = new int[] {4, 2, 4, 5, 3, 1, 9, 6, 7};
        result = s.longestIncreasingSubsequence(nums);
        System.out.printf("result: %d", result);
    }
}
