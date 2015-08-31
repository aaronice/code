public class Solution {
    /**
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 10};
        int target = 5;
        System.out.println("insert position of index: " + s.searchInsert(nums, target));
    }

    public int searchInsert(int[] A, int target) {
        // write your code here

        if (A == null || A.length == 0) {
            return 0;
        }

        int start = 0;
        int end = A.length - 1;
        int mid;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (target > A[mid]) {
                start = mid;
            } else if (target < A[mid]) {
                end = mid;
            } else {
                end = mid;
            }
        }

        if (A[start] >= target) {
            return start;
        } else if (A[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }
}
