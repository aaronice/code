import java.util.Random;

class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return 0;
        }

        return select(nums, 0, nums.length - 1, nums.length - k);

    }

    public int select(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }

        int pivotIndex = partition(nums, left, right);
        if (pivotIndex == k) {
            return nums[pivotIndex];
        } else if (pivotIndex < k) {
            return select(nums, pivotIndex + 1, right, k);
        }  else {
            return select(nums, left, pivotIndex - 1, k);
        }
    }

    public void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public int partition(int[] nums, int left, int right) {

        Random rand = new Random();
        int pivotIndex = rand.nextInt((right - left) + 1) + left;
        // Init pivot
        int pivotValue = nums[pivotIndex];

        swap(nums, pivotIndex, right);

        // First index that nums[firstIndex] > pivotValue
        int firstIndex = left;

        for (int i = left; i <= right - 1; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, firstIndex, i);
                firstIndex++;
            }
        }

        // Recover pivot to array
        swap(nums, right, firstIndex);
        return firstIndex;
    }

    public static void main(String[] args) {
        System.out.println("kth Largest Element: Quick Select");
        int[] A = {21, 3, 34, 5, 13, 8, 2, 55, 1, 19};
        Solution search = new Solution();
        int expResult[] = {1, 2, 3, 5, 8, 13, 19, 21, 34, 55};
        int k = expResult.length;
        int err = 0;
        for (int exp : expResult) {
            if (exp != search.kthLargestElement(k--, A)) {
                System.out.println("Test failed: " + k);
                err++;
            }
        }
        System.out.println("Test finished");
    }
}
