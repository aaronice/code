public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] nums) {
        // write you code here
        Set<Integer> hs = new HashSet<Integer>();
        for (int n : nums) {
            hs.add(n);
        }
        int longest = 0;
        for (int n : hs) {
            if (!hs.contains(n - 1)) {
                int m = n + 1;
                while (hs.contains(m)) {
                    m++;
                }
                longest = Math.max(longest, m - n);
            }
        }
        return longest;
    }
}
