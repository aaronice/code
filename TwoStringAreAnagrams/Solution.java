public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        int[] charList1 = new int[256];
        int[] charList2 = new int[256];
    
        if (s.length() != t.length()) {
            return false;
        } 
        for (int k = 0; k< 256; k++) {
            charList1[k] = 0;
            charList2[k] = 0;
        }
        for (int i = 0; i < s.length(); i++) {
            // System.out.println(Character.getNumericValue(s.charAt(i)));
            // System.out.println(Character.getNumericValue(t.charAt(i)));
            if (Character.getNumericValue(s.charAt(i)) != -1)
                charList1[Character.getNumericValue(s.charAt(i))] += 1;
            if (Character.getNumericValue(t.charAt(i)) != -1)
                charList2[Character.getNumericValue(t.charAt(i))] += 1;
        }
        for (int n = 0; n < 256; n++) {
            if (charList1[n] != charList2[n]) {
                return false;
            }
        }
        return true;
    }
};

