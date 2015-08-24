import java.util.*;

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<Integer> S = new ArrayList<Integer> ();
        S.add(1);
        S.add(2);
        S.add(3);
        ArrayList<ArrayList<Integer>> result = s.subsets(S);
        System.out.println("Result:\n");
        System.out.println("[");
        for (int i = 0; i < result.size(); i++) {
            System.out.println("    " + result.get(i));
        }
        System.out.println("]");
    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (S == null || S.size() == 0) return result;
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.sort(S);
        subsetsHelper(result, list, S, 0);
        return result;
    }

    private void subsetsHelper(ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list, ArrayList<Integer> S, int level) {

        System.out.println("\nEntering a new recursion, level: " + level);
        result.add(new ArrayList<Integer>(list));
        System.out.println("result: " + result);

        for (int i = level; i < S.size(); i++) {

            list.add(S.get(i));
            System.out.println("level = " + level + ", loop i = " + i);
            System.out.println("list: " + list);

            subsetsHelper(result, list, S, i + 1);
            list.remove(list.size() - 1);
        }
        System.out.println("Returning recursion...");
    }
}
