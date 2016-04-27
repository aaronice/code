/*

Given an array of n objects with k different colors (numbered from 1 to k),
sort them so that objects of the same color are adjacent,
with the colors in the order 1, 2, ... k.

 */

public class Solution {
    // O(k) space, O(n) time; two-pass algorithm, counting sort
    public void sortColors2(int[] colors, int k) {
        int[] count = new int[k];
        for (int color : colors) {
            count[color-1]++;
        }
        int index = 0;
        for (int i = 0; i < k; i++) {
            while (count[i]>0) {
                colors[index++] = i+1;
                count[i]--;
            }
        }
    }
}
