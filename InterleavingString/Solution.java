public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
     public boolean isInterleave(String s1, String s2, String s3) {
         if (s1.length() + s2.length() != s3.length()) {
             return false;
         }

         boolean [][] interleaved = new boolean[s1.length() + 1][s2.length() + 1];
         interleaved[0][0] = true;

         for (int i = 1; i <= s1.length(); i++) {
             if(s3.charAt(i - 1) == s1.charAt(i - 1) && interleaved[i - 1][0])
                 interleaved[i][0] = true;
         }

         for (int j = 1; j <= s2.length(); j++) {
             if(s3.charAt(j - 1) == s2.charAt(j - 1) && interleaved[0][j - 1])
                 interleaved[0][j] = true;
         }

         for (int i = 1; i <= s1.length(); i++) {
             for (int j = 1; j <= s2.length(); j++) {
                 if(((s3.charAt(i + j - 1) == s1.charAt(i - 1) && interleaved[i - 1][j]))
                     || ((s3.charAt(i + j - 1)) == s2.charAt(j - 1) && interleaved[i][j - 1]))
                 interleaved[i][j] = true;
             }
         }

         return interleaved[s1.length()][s2.length()];
     }
}
