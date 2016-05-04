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
                int sum = numbers[i] + numbers[pl] + numbers[pr];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    if (target - sum < diff) {
                        diff = target - sum;
                        sign = -1;
                    }
                    pl++;
                } else {
                    if (sum - target < diff) {
                        diff = sum - target;
                        sign = 1;
                    }
                    pr--;
                }
            }
        }
        return target + sign * diff;
    }

    // Use Math.abs(), two pointers
    public int threeSumClosestV2(int[] numbers,int target) {
        if (numbers == null || numbers.length < 3) {
            return Integer.MAX_VALUE;
        }

        Arrays.sort(numbers);

        int length = numbers.length;
        int closest = Integer.MAX_VALUE / 2;

        for (int i = 0; i < length - 2; i++) {
            int pl = i + 1;
            int pr = length - 1;

            while (pl < pr) {
                int sum = numbers[i] + numbers[pl] + numbers[pr];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    pl++;
                } else {
                    pr--;
                }
                closest = Math.abs(sum - target) < Math.abs(closest - target) ?
                        sum : closest;
            }
        }
        return closest;
    }
}
