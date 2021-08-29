package src.medium;

/**
 *  Longest Palindrome Substring
 *  https://leetcode.com/problems/longest-palindromic-substring/
 * 
 *  level: medium
 *  ans: expand left and right around a char, matching the chars
 * 
 */
public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        int N = s.length();
        
        if (N == 0 || N == 1 || s.equalsIgnoreCase("")) 
            return s;
        
        String current = "";
        String maxLen = "";
        
        for (int i=0; i<N; i++) {
            String lenA = expandAroundCenter(s, i, i);
            String lenB = expandAroundCenter(s, i, i+1);
            
            if (lenA.length() > lenB.length() ) {
                current = lenA;
            }
            else {
                current = lenB;
            }
            
            if (current.length() > maxLen.length()) {
                maxLen = current;
            }
            
            if (maxLen.length() == s.length())
                break;
            
        }
        return maxLen;
    }
    
    
    public String expandAroundCenter(String s, int left, int right) {

        String str = ""; 
        
        while (left >= 0 && right < s.length()) {
            
            char l = s.charAt(left);
            char r = s.charAt(right);
            
            if (l == r) {
                str = s.substring(left, right+1);
            }
            else {
                break;
            }
            
            left--;
            right++;
        }
        
        return str;
        
        
    }
}
