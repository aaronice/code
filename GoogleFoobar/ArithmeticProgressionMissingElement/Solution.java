/*
For example :

[-5, 5, 10, 15] -> 0,

[2, 4, 6, 8, 12, 14, 16] -> 10

Try to resolve the problem in O(log(n))

Only one missing element? Yes

if no missing element, return? the first next one -16 -12 -8 -4 0 ->4

what happened if arr size is 1 or 2? assume size >= 3

Input Format

First line contains number of elements N.

Second line has N number of space separated integers

Output Format

Print the missing element

Sample Input

Input

7

2 4 6 8 12 14 16

Sample Output

10

Explanation

Each two elements have the same difference

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public int findMissingNumber(int[] arr, int start, int end, int diff) {
        if (start >= end) {
            System.out.print("start: " + start + ", end: " + end);
            return Integer.MAX_VALUE;
        }

        int mid = start + (end - start) / 2;

        if (arr[mid + 1] - arr[mid] != diff) {
            return (arr[mid] + diff);
        }

        if (mid > 0 && arr[mid] - arr[mid - 1] != diff) {
            return (arr[mid] - diff);
        }

        if (arr[mid] == arr[0] + mid * diff) {
            return findMissingNumber(arr, mid + 1, end, diff);
        }

        return findMissingNumber(arr, start, mid - 1, diff);
    }

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        int N;
        int[] arr;
        int diff;
        System.out.println("Input");

        // Get BufferedReader for System.in.
        BufferedReader in = new BufferedReader(
        new InputStreamReader(System.in));

        // Read line from console.
        String line1 = in.readLine();
        String line2 = in.readLine();
        System.out.println("You typed " + line1);
        System.out.println("You typed " + line2);

        try {
            N = Integer.parseInt(line1);
        } catch (NumberFormatException exception) {
            N = 0;
        }

        if (N < 3) {
            System.out.println("Invalid input N: " + N + " , N must >= 3");
        }

        String[] nums = line2.split(" ");
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }

        diff = (arr[N - 1] - arr[0]) / N;
        System.out.println("diff: " + diff);

        Solution s = new Solution();
        int result = s.findMissingNumber(arr, 0, N - 1, diff);
        System.out.println("result: " + result);
    }
}
