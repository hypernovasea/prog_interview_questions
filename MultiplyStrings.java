/**
 *  Multiply String
 *  https://leetcode.com/problems/multiply-strings/
 * 
 *  level: medium
 *  ans: use array manipulations and math tricks
 */
public class MultiplyStrings {

    public static void main(String[] args) {
        String quo = multiply("123", "456");
        System.out.printf("%s\n", quo);
    }


    public static String multiply(String num1, String num2) {
        
        // if all 0s, than nothing to calculate
        if ("0".equals(num1) || "0".equals(num2))
            return "0";

        // answer will always be both string lengths - 1
        int[] ans = new int[num1.length() + num2.length() - 1];

        // multiply all digits together
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                ans[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        for (int i=0; i<ans.length; i++)
            System.out.printf("%d | ", ans[i]);

        // perform any 'carries' that need to occur
        for (int i = ans.length - 1; i > 0; i--) {

            ans[i - 1] = ans[i - 1] + ans[i] / 10;
            System.out.printf("%d\n", ans[i-1]);
            ans[i] %= 10;
            System.out.printf("%d\n", ans[i]);
        }

        // append ans to new string
        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i);
        }

        return sb.toString();
    }
    
}
