public class Solution {
    /**
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        if (A == null) {
            return 0;
        }

        for (int i = 0; i < A.length; i++) {
            while(A[i] - 1 != i && A[i] > 0) {
                if (A[i] - 1 < A.length && A[A[i] - 1] != A[i]) {
                    swap(A, i, A[i] - 1);
                } else {
                    A[i] = 0;
                }
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= 0) {
                return i + 1;
            }
        }

        return A.length + 1;
    }

    public void swap(int[] A, int l, int r) {
        int tmp = A[l];
        A[l] = A[r];
        A[r] = tmp;
    }

    // SOLUTION 2:
    public int firstMissingPositive2(int[] A) {
        // bug 3: when length is 0, return 1;
        if (A == null) {
            return 0;
        }

        for (int i = 0; i < A.length; i++) {
            // 1: A[i] is in the range;
            // 2: A[i] > 0.
            // 3: The target is different;
            while (A[i] <= A.length && A[i] > 0 && A[A[i] - 1] != A[i]) {
                swap(A, i, A[i] - 1);
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        return A.length + 1;
    }
}
