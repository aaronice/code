class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 3, 3, 4, 5, 10};
        int target = 3;
        System.out.println("first position of index: " + s.binarySearch(nums, target));
    }
    public int binarySearch(int[] nums, int target) {
        //write your code here
        int low  = 0;
        int high = nums.length - 1;
        int mid;

        while (low + 1 < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid;
            } else if (nums[mid] == target) {
                high = mid;
            } else {
                high = mid;
            }
        }

        if (nums[low] == target) {
            return low;
        }

        if (nums[high] == target) {
            return high;
        }

        return -1;
    }
}
