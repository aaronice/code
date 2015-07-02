public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        
        if (A.length() < B.length()) {
            return false;
        }
        
        int[] charList1 = new int[256];
        int[] charList2 = new int[256];
    
        for (int k = 0; k< 256; k++) {
            charList1[k] = 0;
            charList2[k] = 0;
        }
        
        for (int i = 0; i < A.length(); i++) {
            if (Character.getNumericValue(A.charAt(i)) != -1)
                charList1[Character.getNumericValue(A.charAt(i))] += 1;
        }
        
        for (int i = 0; i < B.length(); i++) {
            if (Character.getNumericValue(B.charAt(i)) != -1)
                charList2[Character.getNumericValue(B.charAt(i))] += 1;
        }

        for (int n = 0; n < 256; n++) {
            if (charList1[n] < charList2[n]) {
                return false;
            }
        }
        return true;
    }
}

