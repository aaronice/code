public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        if (S == null || S.length() == 0) {
            return 0;
        }

        int[][] dp = new int[S.length() + 1][T.length() + 1];

        for (int i = 0; i < S.length() + 1; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j < T.length() + 1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < S.length() + 1; i++) {
            for (int j = 1; j < T.length() + 1; j++) {

                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[S.length()][T.length()];

    }
}
