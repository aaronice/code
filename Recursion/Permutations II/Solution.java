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
        S.add(2);
        ArrayList<ArrayList<Integer>> result = s.permuteUnique(S);
        System.out.println("Result:\n");
        System.out.println("[");
        for (int i = 0; i < result.size(); i++) {
            System.out.println("    " + result.get(i));
        }
        System.out.println("]");
    }
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[nums.size()];
        Collections.sort(nums);
        permutationHelper(result, list, nums, visited);
        return result;
    }

    private void permutationHelper(ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list, ArrayList<Integer> nums, int[] visited) {

        // System.out.println("\nEntering a new recursion");
        if (list.size() == nums.size()) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        // System.out.println("result: " + result);

        for (int i = 0; i < nums.size(); i++) {
            if (visited[i] == 1 || (i > 0 && nums.get(i) == nums.get(i - 1) && visited[i - 1] == 0)) {
                continue;
            }
            visited[i] = 1;
            list.add(nums.get(i));
            // System.out.println("loop i = " + i);
            // System.out.println("list: " + list);

            permutationHelper(result, list, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
        // System.out.println("Returning recursion...");
    }
}
