package src;

/**
 *  Plus One
 *  https://leetcode.com/problems/plus-one/
 * 
 *  level: easy
 *  ans: use array manipulations
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] num = plusOne(new int[]{1,2,3});
        printArray(num);

        int[] num2 = plusOne(new int[]{9,9,9});
        printArray(num2);
    }

    public static int[] plusOne(int[] digits) {
        
        if (digits.length == 0)
            return digits;
        
        int i = digits.length-1;
        boolean carry = false;
        
        // starting at end of num, add 1 and carry it
        //  to the beginning of the number
        while (i>=0) {
            
            // adding 1 to 0 - 8 doesn't produce carry
            if (digits[i] >= 0 && digits[i] <= 8) {
                digits[i]++;
                carry = false;
                break;
            } 
            else {
                digits[i] = 0;
                carry = true;
            }
            i--;
        }
        
        // check if carry creates need for new cell
        if (carry) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        }
        
        return digits;
        
    }

    public static void printArray(int[] array) {
        System.out.println("");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d | ", array[i]);
        }
    }
    
}
