/*

Given an array S of n integers, are there elements a, b, c in S
such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.


Notice

Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)

The solution set must not contain duplicate triplets.
*/


// 考虑non-descending，先sort数组，其次考虑去除duplicate
// 类似2sum，可以利用two pointers，不断移动left 和 right 指针，直到找到目标，或者两指针相遇


public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numbers == null || numbers.length < 3) {
            return result;
        }
        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = numbers.length - 1;

            while (left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];
                if (sum == 0) {
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(numbers[i]);
                    tmp.add(numbers[left]);
                    tmp.add(numbers[right]);
                    result.add(tmp);
                    left++;
                    right--;
                    while (left < right && numbers[left] == numbers[left - 1]) {
                        left++;
                    }
                    while (left < right && numbers[right] == numbers[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }

            }
        }
        return result;
    }
}
