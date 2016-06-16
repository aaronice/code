public class Solution {
    /**
     * @param num an integer
     * @return true if num is an ugly number or false
     */
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        int[] primes = new int[]{2, 3, 5};
        for (int i = 0; i < primes.length; i++) {
            while (num % primes[i] == 0) {
                num = num / primes[i];
            }
        }
        return num == 1;
    }
}
