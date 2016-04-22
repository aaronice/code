import java.util.*;

public class Solution {
    /**
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public static void main(String[] args) {
        int[] a = {0,4,4,0,0,2,4,4};
        Solution s = new Solution();
        System.out.print("Result: " + s.removeElement(a, 4) + "\n");
    }
    public int removeElement(int[] A, int elem) {
        // write your code here
        if (A == null) return 0;
        int pointer = A.length - 1;
        int i = 0;
        while(i <= pointer) {
            if(A[i] == elem) {
                A[i] = A[pointer];
                pointer--;
            } else {
                i++;
            }
        }

        System.out.print("[ ");
        for (int k = pointer; k > 0; k--) {
            System.out.print(A[k] + " ");
        }
        System.out.print("]");

        return pointer + 1;
    }
}
