import java.util.HashSet;
import java.util.Set;

/**
 *  Longest Substring without Repeating Characters
 *  https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 *  level: medium
 *  ans: sliding window
 */
public class LongestSubstringWithoutRepeatChars {
    
    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb")); // should return '3'
        System.out.println(lengthOfLongestSubstring("bbbbbb")); // should return '1'
        System.out.println(lengthOfLongestSubstring(""));   // should return '0'

    }


    public static int lengthOfLongestSubstring(String s) {
        
        if (s.length() == 0 || s.length() == 1)
            return s.length();
        
        // set to hold the unique char of strings
        Set<Character> set = new HashSet<Character>();
        int max = 0;    // the max length seen
        int i=0, j=0;   // indices of window length
        
        // Create a sliding window between indices i and j. If set doesn't contain string[j]
        //  then add it to the set. If set contains string[i], keep incrementing i (shortening the window),
        //  until the duplicate char is removed
        while(i < s.length() && j < s.length()){
            char c = s.charAt(j);
            
            if (!set.contains(c)) { // char not in set, increase window
                set.add(c);
                j++;
                max = Math.max(max, j-i); // set max to longest length
            } 
            else { 
                // char already in set, shorten window by removing char at i
                //  and increment i
                set.remove(s.charAt(i));
                i++;
                // do not increment j because the dupe char could still be in the set
            }
        }

        return max;
        
    }
}
