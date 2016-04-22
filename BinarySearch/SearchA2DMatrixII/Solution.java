public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int i = m - 1;
        int j = 0;

        int count = 0;

        while (i >= 0 && j < n) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                count++;
                i--;
                j++;
            }
        }
        return count;
    }
}
