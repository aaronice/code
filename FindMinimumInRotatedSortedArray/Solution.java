public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = {6, 1, 2, 3, 4, 5};
        System.out.println(s.findMin(num));

    }

    public int findMin(int[] num) {
        // write your code here
        int start = 0;
        int end = num.length  - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] > num[start] && num[mid] > num[end]) {
                start = mid;
            } else if (num[mid] < num[start] && num[mid] < num[end]) {
                end = mid;
            } else if (num[mid] > num[start] && num[mid] < num[end]) {
                break;
            }
            // System.out.println("start: " + start + " end: " + end);
        }

        if (num[start] < num[end]) {
            return num[start];
        } else {
            return num[end];
        }
    }
}


/* Solution 2: more succinct */

// public class Solution {
//     /**
//      * @param num: a rotated sorted array
//      * @return: the minimum number in the array
//      */
//     public int findMin(int[] nums) {
//         if (nums == null || nums.length == 0) {
//             return -1;
//         }
//
//         int start = 0, end = nums.length - 1;
//         int target = nums[nums.length - 1];
//
//         // find the first element <= target
//         while (start + 1 < end) {
//             int mid = start + (end - start) / 2;
//             if (nums[mid] <= target) {
//                 end = mid;
//             } else {
//                 start = mid;
//             }
//         }
//         if (nums[start] <= target) {
//             return nums[start];
//         } else {
//             return nums[end];
//         }
//     }
// }
