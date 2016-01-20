public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = new int[] {22,25,100,209,1000,1110,1111};
        int target = 15;

        System.out.println(s.closestNumber(A, target));
    }
    public int closestNumber(int[] A, int target) {

        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        int index;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target > A[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        // System.out.println("start: " + start);
        // System.out.println("end: " + end);

        if (target == A[start]) {
            index = start;
        } else if (target == A[end]) {
            index = end;
        } else {
            if (Math.abs(A[start] - target) <= Math.abs(A[end] - target)) {
                index = start;
            } else {
                index = end;
            }
        }

        return index;
    }
}
