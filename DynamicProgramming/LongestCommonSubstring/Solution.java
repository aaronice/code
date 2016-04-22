public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public static void main(String[] args) {
        Solution s = new Solution();
        String A = "GABCDEFG";
        String B = "CEDADFGABC";
        System.out.print("length of the longest common substring: " + s.longestCommonSubstring(A, B) + "\n");
    }

    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int maxLength = 0;
        int startIndex = 0;
        int lengthA = A.length();
        int lengthB = B.length();

        for (int i = 0; i < lengthA ; i++ ) {
            for (int j = 0; j < lengthB ; j++) {
                int len = 0;

                while(A.charAt(i + len) == B.charAt(j + len)) {
                    len++;
                    if ((i + len >= lengthA) || (j + len >= lengthB)) break;
                }
                if (len > maxLength) {
                    maxLength = len;
                    startIndex = i;
                }
            }
        }
        return maxLength;

    }
}
