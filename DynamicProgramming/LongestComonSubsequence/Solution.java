public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */

    public int longestCommonSubsequence(String A, String B) {
        // write your code here

        if (A == null || B == null) {
            return 0;
        }

        int M = A.length();
        int N = B.length();

        if (M == 0 || N == 0) {
            return 0;
        }

        int[][] mat = new int[M + 1][N + 1];

        for (int i = 0; i < M + 1; i++) {
            mat[i][0] = 0;
        }

        for (int j = 0; j < N + 1; j++) {
            mat[0][j] = 0;
        }

        for (int i = 1; i < M + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                } else {
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
                }
            }
        }

        return mat[M][N];
    }

}
