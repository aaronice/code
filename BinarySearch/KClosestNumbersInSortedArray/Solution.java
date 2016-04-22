
/**
 * Given a target number, a non-negative integer k and an integer array A sorted
 * in ascending order, find the k closest numbers to target in A, sorted in
 * ascending order by the difference between the number and target.
 * Otherwise, sorted in ascending order by number if the difference is same.
 */


public class Solution {
    /**
     * @param A an integer array
     * @param target an integer
     * @param k a non-negative integer
     * @return an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // Write your code here

        if (k == 0) {
            int[] empty = {};
            return empty;
        }

        int pivot = findCrossOver(A, target);

        if (pivot == -1) {
            int[] empty = {};
            return empty;
        }

        int count = 0;
        int left;
        int right;
        int[] result = new int[k];

        if (A[pivot] == target) {
            result[count] = A[pivot];
            count++;
            left = pivot - 1;
        } else {
            left = pivot;
        }

        right = pivot + 1;

        while (left >= 0 && right < A.length && count < k) {
            if (target - A[left] <= A[right] - target) {
                result[count] = A[left--];
            } else {
                result[count] = A[right++];
            }
            count++;
        }

        while (count < k && left >= 0) {
            result[count] = A[left--];
            count++;
        }

        while (count < k && right < A.length) {
            result[count] = A[right++];
            count++;
        }

        return result;
    }

    public int findCrossOver(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;

        if (target > A[end]) {
            return end;
        } else if (target < A[start]) {
            return start;
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target < A[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (A[start] == target) {
            return start;
        }

        if (A[end] == target) {
            return end;
        }

        if (target < A[end] && target > A[start]) {
            if (target - A[start] <= A[end] - target) {
                return start;
            } else {
                return end;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A;
        int target;
        int k = 3;
        int[] result;

        // Test Case I
        A = new int[] {1, 4, 6, 8};
        target = 3;
        result = s.kClosestNumbers(A, target, k);
        System.out.println("A[]: [1, 4, 6, 8], target: 3, k: 3");
        for (int e : result) {
            System.out.print(e + " ");
        }
        System.out.println("");

        // Test Case II
        A = new int[] {1, 2, 3};
        target = 2;
        k = 3;
        result = s.kClosestNumbers(A, target, k);
        System.out.println("A[]: [1, 2, 3], target: 2, k: 3");
        for (int e : result) {
            System.out.print(e + " ");
        }
        System.out.println("");

        // Test Case III
        A = new int[] {1,10,15,25,35,45,50,59};
        target = 30;
        k = 7;
        result = s.kClosestNumbers(A, target, k);
        System.out.println("A[]: [1,10,15,25,35,45,50,59], target: 30, k: 7");
        for (int e : result) {
            System.out.print(e + " ");
        }
        System.out.println("");

    }
}
