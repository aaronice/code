public class Solution {
/**
 * @param strs: A list of strings
 * @return: The longest common prefix
 */
    public static void main(String[] args) {
            Solution s = new Solution();
            String[] strs = {"ABCDEFG", "ABCEFG", "ABCEFA"};
            System.out.print("LCP: " + s.longestCommonPrefix(strs) + "\n");
    }

    public String longestCommonPrefix(String[] strs) {
        // write your code here

        if (strs.length == 0) return ""; // strs = []

        String LCP = strs[0];
        int maxLength = LCP.length();

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("")) return ""; // strs[i] = ""
            int len = 0;
            while(LCP.charAt(len) == strs[i].charAt(len)) {
                len++;
                if ((len) >= LCP.length() || (len) >= strs[i].length()) break;
            }
            if (len < maxLength) {
                maxLength = len;
                LCP = LCP.substring(0, len);
            }
        }
        return LCP;
    }
}
