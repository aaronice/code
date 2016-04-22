// A robot is located at the top-left corner of a m x n grid
// (marked 'Start' in the diagram below).
//
// The robot can only move either down or right at any point in time.
// The robot is trying to reach the bottom-right corner of the grid
// (marked 'Finish' in the diagram below).
//
// How many possible unique paths are there?


// Recursive; Top down, saving previously computed result, also known as memoization
public class Solution {
    HashMap<String, Integer> hashmap = new HashMap<String, Integer>();

    private static String makeKey(int m, int n) {
        return m + "," + n;
    }

    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        int paths;

        if (m == 1) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }

        if (this.hashmap.containsKey(makeKey(m, n))) {
            paths = hashmap.get(makeKey(m, n));
        } else {
            paths = uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
            this.hashmap.put(makeKey(m, n), paths);
        }
        return paths;
    }
}

// 2D dynamic programmin, initialize row 0, coloumn 0, iterative soltuion
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {
            sum[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            sum[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
            }
        }
        return sum[m - 1][n - 1];
    }
}
