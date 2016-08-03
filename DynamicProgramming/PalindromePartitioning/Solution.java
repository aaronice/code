import java.util.*;

public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return result;
        }
        partitionHelper(s, list, result);
        return result;
    }

    /**
     * Partition of the string, with Depth First Search
     * @param  s - sub string
     * @param  list - one valid partition result list
     * @param  result - all valid partition results list
     */
    private void partitionHelper(String s, List<String> list, List<List<String>> result) {
        if (s.length() == 0) {
            result.add(new ArrayList<String>(list));
        }
        int len = s.length();

        for (int i = 1; i <= len; i++) {
            String substr = s.substring(0, i);
            if (isPalindrome(substr)) {
                list.add(substr);
                String restSubStr = s.substring(i);
                partitionHelper(restSubStr, list, result);
                list.remove(list.size() - 1);
            }
        }

    }

    /**
     * Determine if a string is palindrome
     * @param  s : string
     * @return   boolean
     */
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * main function
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new Solution().partition("aabaa"));
    }
}
