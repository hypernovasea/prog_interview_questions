
/**
 *  Extra Char
 *  https://www.geeksforgeeks.org/find-one-extra-character-string/
 * 
 *  level: easy
 *  ans: use the fact that characters can be used like integers
 */
public class ExtraChar {

	public static void main(String[] args) {

		System.out.printf("missing char: %c\n", extraChar("abcde", "abcd")); // should return 'e'
        System.out.printf("missing char: %c\n", extraChar("xklmn", "xklm")); // should return 'n'
	}
	
	
	public static char extraChar(String a, String b) {

        int strA=0;
        for (int i=0; i<a.length(); i++) {
            strA += a.charAt(i);
        }
		
        int strB = 0;
        for (int j=0; j<b.length(); j++) {
            strB += b.charAt(j);
        }
		
        return (char)(Math.abs(strA-strB));
	}

}
