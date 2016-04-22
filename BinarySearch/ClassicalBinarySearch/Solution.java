public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int findPosition(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target < A[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (target == A[start]) {
            return start;
        }
        if (target == A[end]) {
            return end;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = new int[] {1, 2, 2, 4, 5, 5};
        int target;
        int position;

        target = 2;
        position = s.findPosition(A, target);
        System.out.println("target: " + target + ", result: " + position);

        target = 5;
        position = s.findPosition(A, target);
        System.out.println("target: " + target + ", result: " + position);

        target = 6;
        position = s.findPosition(A, target);
        System.out.println("target: " + target + ", result: " + position);

    }
}
