/*

Given an array of n objects with k different colors (numbered from 1 to k),
sort them so that objects of the same color are adjacent,
with the colors in the order 1, 2, ... k.

Reference:
http://blog.welkinlan.com/2015/08/25/sort-colors-i-ii-leetcode-lintcode-java/
http://www.cnblogs.com/yuzhangcmu/p/4177326.html
 */

public class Solution {
    /**
     * Method I: O(k) space, O(n) time; two-pass algorithm, counting sort
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2TwoPass(int[] colors, int k) {
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

    /**
     * Method II:
     *  Each time sort the array into three parts:
     *  [all min] [all unsorted others] [all max],
     *  then update min and max and sort the [all unsorted others]
     *  with the same method.
     *
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        int pl = 0;
        int pr = colors.length - 1;
        int i = 0;
        int min = 1, max = k;
        while (min < max) {
            while (i <= pr) {
                if (colors[i] == min) {
                    swap(colors, pl, i);
                    i++;
                    pl++;
                } else if (colors[i] == max) {
                    swap(colors, pr, i);
                    pr--;
                } else {
                    i++;
                }
                // printArray(colors);
            }
            i = pl;
            min++;
            max--;
        }
    }

    private void swap(int[] colors, int i, int j) {
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] colors = new int[]{2, 5, 3, 4, 2, 2, 1};
        int k = 5;
        s.sortColors2(colors, k);
    }
    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("\n");
    }
}
