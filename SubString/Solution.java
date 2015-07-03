class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        
        if (source == null || target == null) {
            return -1;
        }
        
        if (source.length() < target.length()) {
            return -1;
        }
        
        if (source.length() >= 0 && target.length() == 0) {
            return 0;
        }
        
        int sourceLength = source.length();
        int targetLength = target.length();
        
        int flag = -1; // Whether sub string exist
        
        for (int i = 0; i < sourceLength - targetLength + 1; i++) {
            for (int j = 0; j < targetLength; j++) {
            	if (source.charAt(i + j) == target.charAt(j)) {
            		flag = 1;
            		continue;
            	} else if( source.charAt(i + j) != target.charAt(j)) {
                    flag = -1;
                    break;
                } 
            }
			if (flag == 1) {
				return i;
			} else if (flag == -1) {
				continue;
			}
        }

        if (flag == -1) {
        	return -1;
        }
        
        return -1;
    }
}
