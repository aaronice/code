public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        int min = num[0];
        for (int i = 0; i < num.length; i++) {
            if (num[i] < min) {
                min  = num[i];
            }
        }
        return min;
    }
}
