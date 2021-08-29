package src.easy;

/**
 *  Remove Vowels From a String
 *  https://leetcode.com/problems/remove-vowels-from-a-string/
 * 
 *  level: easy
 *  ans: either use Java built-in function replaceAll or create a new
 *          string by only appending the consanants
 */
public class RemoveVowels {

    public static void main(String[] args) {

        // should return "ltcdscmmntyfrcdrs"
        System.out.println(removeVowelsReplace("leetcodeisacommunityforcoders"));
        System.out.println(removeVowels("leetcodeisacommunityforcoders"));

        // should return ""
        System.out.println(removeVowelsReplace("aeiou"));
        System.out.println(removeVowels("aeiou"));

    }

    public static String removeVowelsReplace(String S) {
        // this code although neat is slower than code below
        return (S.replaceAll("[aeiou]", ""));
    }


    public static String removeVowels(String S) {
        StringBuilder str = new StringBuilder();
        for (char c : S.toCharArray()) {
            
            if (c != 'a' && c != 'e' && c != 'i' 
                    && c != 'o' && c != 'u') {
                str.append(c);
            }
        }
        return str.toString();
    }
    
}
