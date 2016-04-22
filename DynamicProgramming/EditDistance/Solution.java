public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        int m = word1.length();
        int n = word2.length();

        int[][] D = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            D[i][0] = i;
        }

        for (int j = 0; j < n + 1; j++) {
            D[0][j] = j;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    D[i][j] = D[i - 1][j - 1];
                } else {
                    D[i][j] = 1 + Math.min(Math.min(D[i - 1][j], D[i][j - 1]), D[i - 1][j - 1]);
                }
            }
        }

        return D[m][n];

    }
}
