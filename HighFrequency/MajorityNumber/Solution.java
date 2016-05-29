public class Solution {
    /**
     * @param nums: a array of integers
     * @return: find a majority element
     */
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int candidate = nums[0], counter = 0;
        for (int i : nums) {
            if (counter == 0) {
                candidate = i;
                counter = 1;
            } else if (candidate == i) {
                counter++;
            } else {
                counter--;
            }
        }

        counter = 0;
        for (int i : nums) {
            if (i == candidate) counter++;
        }
        if (counter < (n + 1) / 2) return -1;
        return candidate;
    }
}
