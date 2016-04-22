public class Solution {
    /**
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        if (A.length == 0) {
            return new int[]{-1, -1};
        }

        int start;
        int end;
        int mid;
        int[] bound = new int[2];

        // Search for left range
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (target == A[mid]) {
                end = mid;
            } else if (target > A[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] == target) {
            bound[0] = start;
        } else if (A[end] == target) {
            bound[0] = end;
        } else {
            bound[0] = -1;
            bound[1] = -1;
            return bound;
        }

        // Search for right range
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (target == A[mid]) {
                start = mid;
            } else if (target > A[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target) {
            bound[1] = end;
        } else if (A[start] == target) {
            bound[1] = start;
        } else {
            bound[0] = -1;
            bound[1] = -1;
            return bound;
        }

        return bound;
    }
}
