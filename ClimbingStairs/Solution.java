public class Solution {

    HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
    /**
    * @param n: An integer
    * @return: An integer
    */
    public int climbStairs(int n) {
        // write your code here
        int result;

        if (n < 1) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (n > 2) {
            if (this.hashmap.containsKey(n)) {
                return this.hashmap.get(n);
            } else {
                result = climbStairs(n - 1) + climbStairs(n - 2);
                this.hashmap.put(n, result);
            }
            return result;
        }

        return 1;
    }
}
