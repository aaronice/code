// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.

public class Solution {
    /**
    * @param numbers: Give an array numbers of n integer
    * @param target : An integer
    * @return : return the sum of the three integers, the sum closest target.
    */
    public int threeSumClosest(int[] numbers,int target) {
        if (numbers == null || numbers.length < 3) {
            return Integer.MAX_VALUE;
        }

        Arrays.sort(numbers);

        int diff = Integer.MAX_VALUE / 2;
        int length = numbers.length;
        int sign = 1;

        for (int i = 0; i < length - 2; i++) {
            int pl = i + 1;
            int pr = length - 1;

            while (pl < pr) {
                int tmp = numbers[i] + numbers[pl] + numbers[pr];
                if (tmp == target) {
                    return tmp;
                } else if (tmp < target) {
                    if (target - tmp < diff) {
                        diff = target - tmp;
                        sign = -1;
                    }
                    pl++;
                } else {
                    if (tmp - target < diff) {
                        diff = tmp - target;
                        sign = 1;
                    }
                    pr--;
                }
            }
        }
        return target + sign * diff;
    }
}
