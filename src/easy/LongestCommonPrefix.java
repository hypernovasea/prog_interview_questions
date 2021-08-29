package src.easy;

/**
 *  Longest Common Prefix
 *  https://leetcode.com/problems/longest-common-prefix/
 * 
 *  level: easy
 *  ans: brute force method (compare each string to the first and lop off the 
 *      different characters when you see them)
 * 
 *  better and: use indexOf to horizontally scan
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};
        String[] strs3 = {""};
        String[] strs4 = {"state"};

        // should return 'fl'
        System.out.printf("longest common prefix: %s\n", longestCommonPrefix(strs1));
        
        // should return ''
        System.out.printf("longest common prefix: %s\n", longestCommonPrefix(strs2));
        
        // should return ''
        System.out.printf("longest common prefix: %s\n", longestCommonPrefix(strs3));

        // should return 'state'
        System.out.printf("longest common prefix: %s\n", longestCommonPrefix(strs4));

    }

    public static String longestCommonPrefix(String[] strs) {

        // either 1. only 1 string so the entire string is the prefix OR 
        //  first string is empty so the shortest prefix is empty
        if (strs.length == 1 || strs[0].length() == 0) 
            return strs[0];

        // set the current prefix to the first string in array
        StringBuilder prefix = new StringBuilder(strs[0]);

        // first string is not empty so comparisons can be made
        for (int i=1; i<strs.length; i++) {

            String s = strs[i];

            // determine which string, prefix or array string, is shorter
            int shorter = (prefix.length() > s.length()) ? s.length() : prefix.length();
            
            // compare each char in both strings to each other
            StringBuilder commonPrefix = new StringBuilder();
            for (int j=0; j<shorter; j++) {

                // chars match so append them to common prefix string
                if (prefix.charAt(j) == s.charAt(j)) 
                    commonPrefix.append(prefix.charAt(j));
                else 
                    break;   
            }
            prefix = new StringBuilder(commonPrefix.toString());

            if (prefix.length() == 0) {
                return "";
            }
        }
        return prefix.toString();
    }
    
}
