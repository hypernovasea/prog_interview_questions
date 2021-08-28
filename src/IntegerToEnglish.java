package src;

/**
 *  Given a positive integer, i, return the English equivalent.
 * 
 *  Constraints:
 *      - 0 <= i <= 999999999
 */
public class IntegerToEnglish {

    // must keep track of 
    //  1. place value of individual digit (determines wording for digits)
    //  2. place of numerical section (determines billions, millions, hundred thousands, etc)
    static String[] ones = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    static String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static String[] thousands = {"", "Thousand", "Million", "Billion"};


	public static void main(String[] args) {
        System.out.printf("1,234,567 --> %s\n", numberToWords(1234567));
        System.out.printf("0 --> %s\n", numberToWords(0));
        System.out.printf("34 --> %s\n", numberToWords(34));
        System.out.printf("999999999999 --> %s ", numberToWords(999999999));
	}
	

    public static String numberToWords(long num) {

        if (num < 10) 
            return ones[(int)num];

        long currNum = num; // running total of given num
        int level = 0;  // indicates the place in num
        StringBuilder numWords = new StringBuilder("");
        
        // since breaking num into sections, make sure it stays above 0
        while (currNum > 0) { 
            long three = currNum % 1000;   // break num by hundreds;
            String section = translateSection(three).trim(); 
            
            // if section has length 0, then a 0 was translated
            if (section.length() != 0) {
                String formattedSection = String.format("%s %s ", section, thousands[level]);
                numWords.insert(0, formattedSection);
            }

            level++;    // going to a higher place value
            currNum = (currNum - three) / 1000; // remove last 3 nums in value
        }
        
        return numWords.toString();
    }
    
    
    /**
     * Translates numbers by the hundreds.
     * @param num
     * @return String version of number given
     */
    public static String translateSection(long num) { 

        // no number so empty string
        if (num == 0) {
            return "";
        }
        // teens and ones have specific words so can terminate once
        //  those levels are reached
        else if (num < 10) { 
            return ones[(int)num];
        }
        else if(num >= 10 && num < 20) {
            return teens[(int)num % 10]; 
        }
        // tens and hundreds require further translation
        // division gets the leading number while mod division isolates the remaining numbers
        else if (num >= 20 && num <= 99) {
            long x = num / 10;
            return String.format("%s %s", tens[(int)x], translateSection(num % 10)); 
        }
        else if (num >= 100) {
            long x = num / 100; 
            return String.format("%s Hundred %s", ones[(int)x], translateSection(num % 100)); 
        }
        
        return " ";  
    }

}
