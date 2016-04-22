public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int target = 3;
        Solution s = new Solution();
        boolean result = s.searchMatrix(matrix, target);
        System.out.println("result: " + result);
    }


    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int column = matrix[0].length;
        int row = matrix.length;
        int start = 0;
        int end = column * row - 1;
        int mid;

        while (start + 1 < end) {
            mid = start + (end - start)/2;
            System.out.println("mid: " + mid);
            if (matrix[mid / column][mid % column] < target) {
                start = mid;
            } else if (matrix[mid / column][mid % column] > target) {
                end = mid;
            } else {
                end = mid;
                return true;
            }
        }

        if (matrix[start/column][start%column] == target) {
            return true;
        } else if (matrix[end/column][end%column] == target) {
            return true;
        }

        return false;
    }
}
