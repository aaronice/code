// Follow up for "Unique Paths":
//
// Now consider if some obstacles are added to the grids.
// How many unique paths would there be?
//
// An obstacle and empty space is marked as 1 and 0 respectively in the grid.

public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int m;
        int n;

        if (obstacleGrid == null || obstacleGrid.length == 0 ||
            obstacleGrid[0].length == 0) {
            return 0;
        }

        m = obstacleGrid.length;
        n = obstacleGrid[0].length;

        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] sum = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                sum[i][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                sum[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    sum[i][j] = sum[i][j - 1] + sum[i - 1][j];
                } else {
                    sum[i][j] = 0;
                }
            }
        }
        return sum[m - 1][n - 1];

    }
}
