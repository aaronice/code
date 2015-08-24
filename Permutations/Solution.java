import java.util.*;

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<Integer> S = new ArrayList<Integer>();
        S.add(1);
        S.add(2);
        S.add(3);
        ArrayList<ArrayList<Integer>> result = s.permute(S);
        System.out.println("Result:\n");
        System.out.println("[");
        for (int i = 0; i < result.size(); i++) {
            System.out.println("    " + result.get(i));
        }
        System.out.println("]");
    }
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        permutationHelper(result, list, nums);
        return result;
    }

    private void permutationHelper(ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list, ArrayList<Integer> nums) {

        // System.out.println("\nEntering a new recursion");
        if (list.size() == nums.size()) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        // System.out.println("result: " + result);

        for (int i = 0; i < nums.size(); i++) {
            if (list.contains(nums.get(i))) {
                continue;
            }

            list.add(nums.get(i));
            // System.out.println("loop i = " + i);
            // System.out.println("list: " + list);

            permutationHelper(result, list, nums);
            list.remove(list.size() - 1);
        }
        // System.out.println("Returning recursion...");
    }
}
