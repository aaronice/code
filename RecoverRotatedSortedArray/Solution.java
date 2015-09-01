import java.util.ArrayList;

public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(4);
        nums.add(5);
        nums.add(1);
        nums.add(2);
        nums.add(3);
        s.recoverRotatedSortedArray(nums);
        for (int n = 0; n < nums.size(); n++) {
            System.out.println(nums.get(n));
        }
    }

    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return;
        }
        int pivot = -1;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                pivot = i;
                break;
            }
        }
        if (pivot >= 0) {
            reverseArray(nums, 0, pivot);
            if (pivot < nums.size() - 1) {
                reverseArray(nums, pivot + 1, nums.size() - 1);
            }
            reverseArray(nums, 0, nums.size() - 1);
        }
    }

    public void reverseArray(ArrayList<Integer> arr, int start, int end) {
        Integer temp;

        int i = start, j = end;
        for (; i < j; i++, j--) {
            temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
        }
    }
}
