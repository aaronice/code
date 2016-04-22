class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        int first = 0, second = 1;
        int next = 0;

        for (int i = 1; i <= n; i++) {
            if (i <= 2) {
                next = i - 1;
            } else {
                next = first + second;
                first = second;
                second = next;
            }
        }

        return next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int input;
        if (args != null && args.length > 0) {
            input = Integer.parseInt(args[0]);
        } else {
            input = 3;
        }

        System.out.println("input: " + input);
        System.out.println(s.fibonacci(input));
    }
}
