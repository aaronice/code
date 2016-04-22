import java.util.*;

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */

    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();

        triangle.add(new ArrayList<Integer>(Arrays.asList(2)));
        triangle.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
        triangle.add(new ArrayList<Integer>(Arrays.asList(6, 5, 7)));
        triangle.add(new ArrayList<Integer>(Arrays.asList(4, 1, 8, 3)));

        System.out.println("minimumTotal: " + s.minimumTotal(triangle));
    }
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // write your code here

        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int n = triangle.size();

        // States definition; minimum path sum from (i, j) to the bottom
        int[][] sum = new int[n][n];

        // Initialization
        for (int i = 0; i < n; i++) {
            sum[n-1][i] = triangle.get(n-1).get(i);
        }

        // Looping for the result
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                sum[i][j] = Math.min(sum[i+1][j], sum[i+1][j+1]) + triangle.get(i).get(j);
            }
        }

        return sum[0][0];
    }


}
