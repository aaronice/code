import java.util.*;

public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if (s == null || t == null) {
            return false;
        }

        int[] alphabet = new int[256];

        Arrays.fill(alphabet, 0);

        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i);
            alphabet[num] = alphabet[num] + 1;
        }

        for (int j = 0; j < t.length(); j++) {
            int num = t.charAt(j);
            alphabet[num] = alphabet[num] - 1;
        }

        for (int k = 0; k < 256; k++) {
            if (alphabet[k] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean isAnagram = s.anagram("abcd", "aabd");
        System.out.println(isAnagram);
    }
};
