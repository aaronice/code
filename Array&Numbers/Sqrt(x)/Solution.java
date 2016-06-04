class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        int result = 0;
       long start = 1;
       long end = x;

       while (start + 1 < end) {
           long mid = start + (end - start) / 2;
           if (mid * mid == x) {
                return (int) mid;
           } else if (mid*mid > x) {
               end = mid;
           } else {
               start = mid;
           }
       }

       if (end*end <= x) {
           return (int) end;
       }

       return (int) start;
    }
}
