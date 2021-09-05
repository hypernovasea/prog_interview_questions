package src.medium;

import java.util.HashMap;
import java.util.Map;

/**
 *  Longest Substring with At Most K Distinct Characters
 *  https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * 
 *  level: medium
 *  ans: sliding window (see educative for an explanation)
 */
public class LongestSubstringWithKDistinctChars {
    public static void main(String[] args) {

        int i = lengthOfLongestSubstringKDistinct("eceba", 2);
        System.out.printf("length of longest substring: %d\n", i);

        int j = lengthOfLongestSubstringKDistinct("aa", 1);
        System.out.printf("length of longest substring: %d\n", j);
    }


    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        // empty string or empty k, return 0
        if (k == 0 || s.length() == 0)
            return 0;

        int start=0, maxSubstr = 0;
        
        // create a map to store the frequency of each char
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        // create a window from start to end, extending it when the map size
        // remains under or at, k
        for(int end = 0; end<s.length(); end++) {
            char right = s.charAt(end);  // increase the window length
            
            // increase character frequency
            map.put(right, map.getOrDefault(right, 0) + 1);

            // shrink window size until it equals k
            while (map.size() > k) {
                // get the char from beginning of window
                //  since we will be removing it
                char left = s.charAt(start);

                // decrease frequency
                map.put(left, map.get(left) - 1);

                // remove character altogether if its frequency is 0 
                if (map.get(left) == 0)
                    map.remove(left);

                // increment start index (shrinking window size)
                start++; 
            }
            
            // update the max substring if needed
            maxSubstr = Math.max(maxSubstr, end - start + 1);  
        }

        return maxSubstr;
    }
}
