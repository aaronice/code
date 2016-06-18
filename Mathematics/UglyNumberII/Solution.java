import java.util.ArrayList;

class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        ArrayList<Integer> uglyNumbers = new ArrayList<Integer>();
        uglyNumbers.add(1);
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int current = 2;

        for (int i = 0; i < n; i++) {
            while (uglyNumbers.get(p1) * 2 < current) {
                p1++;
            }
            int min1 = uglyNumbers.get(p1) * 2;

            while (uglyNumbers.get(p2) * 3 < current) {
                p2++;
            }
            int min2 = uglyNumbers.get(p2) * 3;

            while (uglyNumbers.get(p3) * 5 < current) {
                p3++;
            }
            int min3 = uglyNumbers.get(p3) * 5;

            int next = Math.min(Math.min(min1, min2), min3);
            current = next + 1;
            uglyNumbers.add(next);
        }
        return uglyNumbers.get(n - 1);
    }
}
