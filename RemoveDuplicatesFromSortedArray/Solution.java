public class Solution {
    /**
     * @param nums: a array of integers
     * @return : return an integer
     */
   public int removeDuplicates(int[] nums) {
        // write your code here

        if (nums == null || nums.length == 0) return 0;

        int len = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != nums[len]) {
                nums[++len] = nums[i];
            }
        }

        return len + 1;
    }
}
