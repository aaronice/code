class Solution {
    /**
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = {7, 8, 9, 0, 0};
        int[] B = {5, 6};
        int m = 3;
        int n = 2;
        s.mergeSortedArray(A, m, B, n);
        for (int e : A) {
            System.out.println(e);
        }
    }
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;
        while (i >= 0 && j >= 0){
            if (A[i] > B[j]) {
                A[index--] = A[i--];
            } else if (A[i] <= B[j]){
                A[index--] = B[j--];
            }
        }
        while (i >= 0) {
            A[index--] = A[i--];
        }
        while (j >= 0) {
            A[index--] = B[j--];
        }

    }
}
