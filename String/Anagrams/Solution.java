import java.lang.String;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */

    // public static void main(String[] args) {
    //     Solution s = new Solution();
    //     String[] strs = {"ab", "ba", "cd", "dc", "e"};
    //     System.out.print(s.anagrams(strs));
    // }

    public List<String> anagrams(String[] strs) {
        // write your code here
        if (strs == null) return null;
        List<String> result = new ArrayList<String>();
        Set<Integer> anagramsIndex = new HashSet<Integer>();

        for (int i = 0; i < strs.length; i++) {
            if (anagramsIndex.contains(i)) continue;
            boolean flag = false;
            List<String> tempList = new ArrayList<String>();

            for(int j = i + 1; j<strs.length; j++) {
                if (anagramsIndex.contains(j)) continue;

                if (checkAnagrams(strs[i], strs[j])) {
                    flag = true;
                    tempList.add(strs[j]);
                    anagramsIndex.add(j);
                }
            }
            if (flag == true) {
                anagramsIndex.add(i);
                result.add(strs[i]);
                result.addAll(tempList);
            }
        }
        return result;
    }


    public boolean checkAnagrams(String s, String t) {
        if (s.length() != t.length()) {
           return false;
        }

        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[(int) s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[(int) t.charAt(i)]--;
            if (count[(int) t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}
