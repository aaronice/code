public class Solution {
    /**
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = {4, 5, 1, 2, 3};
        // int target = 1;
        int target = 0;
        int index = s.search(A, target);
        System.out.println("index: " + index);
    }
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;

            if (A[mid] == target) {
                return mid;
            }
            if (A[start] < A[mid]) {
                if (target <= A[mid] && target >= A[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target >= A[mid] && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (A[start] == target) {
            return start;
        }

        if (A[end] == target) {
            return end;
        }

        return -1;
    }
}
