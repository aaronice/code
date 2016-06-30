import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        String[] nQueens = new String[n];
        char[] init = new char[n];
        Arrays.fill(init, '.');
        Arrays.fill(nQueens, String.valueOf(Arrays.copyOf(init, n)));
        search(n, 0, nQueens, result);
        return result;
    }


    private void search(int n, int row, String[] nQueens, ArrayList<ArrayList<String>> result) {
        if (row == n) {
            result.add(new ArrayList<String>(Arrays.asList(nQueens)));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(nQueens, row, col, n)) {
                char[] chars;
                chars = nQueens[row].toCharArray();
                chars[col] = 'Q';
                nQueens[row] = String.valueOf(chars);
                // nQueens[row][col] = 'Q';
                search(n, row + 1, nQueens, result);
                chars = nQueens[row].toCharArray();
                chars[col] = '.';
                nQueens[row] = String.valueOf(chars);
                // nQueens[row][col] = '.';
            }
        }
    }

    private boolean isValid(String[] nQueens, int row, int col, int n) {
        char[] chars;
        for (int i = 0; i < row; i++) {
            chars = nQueens[i].toCharArray();
            if (chars[col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            chars = nQueens[i].toCharArray();
            if (chars[j] == 'Q') {
                return false;
            }
        }

        for (int  i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            chars = nQueens[i].toCharArray();
            if (chars[j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<ArrayList<String>> res = s.solveNQueens(Integer.valueOf(args[0]));
        // java Solution 4
        System.out.println(res);
        //[[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]
    }
};
