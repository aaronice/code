// Given a string s and a dictionary of words dict,
// determine if s can be break into a space-separated
// sequence of one or more dictionary words.


public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if (s == null || s.length() == 0) {
            return true;
        }

        if (dict == null || dict.isEmpty() == true) {
            return false;
        }

        int maxLength = 0;

        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }

        boolean[] canBreak = new boolean[s.length() + 1];

        canBreak[0] = true;

        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (i - j > maxLength) {
                    break;
                }

                String word = s.substring(j, i);

                if (dict.contains(word) && canBreak[j]) {
                    canBreak[i] = true;
                    break;
                }
            }
        }

        return canBreak[s.length()];

    }
}
