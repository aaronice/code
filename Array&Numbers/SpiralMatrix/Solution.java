/**
 * Given a matrix of m x n elements (m rows, n columns),
 * return all elements of the matrix in spiral order.
 */

public class Solution {
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // Write your code here
        if (matrix == null) {
            return null;
        }

        List<Integer> list = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return list;
        }

        int rowStart = 0;
        int rowEnd = matrix.length - 1;

        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                list.add(matrix[rowStart][i]);
            }
            rowStart++;

            for (int j = rowStart; j <= rowEnd; j++) {
                list.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowStart <= rowEnd) {
                for (int m = colEnd; m >= colStart; m--) {
                    list.add(matrix[rowEnd][m]);
                }
                rowEnd--;
            }

            if (colStart <= colEnd) {
                for (int n = rowEnd; n >= rowStart; n--) {
                    list.add(matrix[n][colStart]);
                }
                colStart++;
            }
        }
        return list;
    }
}
