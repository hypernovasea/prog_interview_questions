package src.misc;


public class BinaryDecimalConvert {

    public static void main(String[] args) {
        int x = 0b11101110110;  // '1910' in decimal
        System.out.println(binaryToDecimal(x)); // should print '1910'

        String y = "101.1";
        System.out.println(binaryStringToDecimal(y)); // should print '5.5'
    }


    /**
     * Takes a binary number and converts it to the decimal equivalent
     * @param binNum A binary number
     * @return The decimal equivalent of given binary number
     */
    public static int binaryToDecimal(int binNum) {
        int total = 0;

        int i = 0;
        while (binNum > 0) {

            int bitAt = (binNum & 1); // check if bit is set at place i
            if (bitAt == 1) {
                total += Math.pow(2, i);
            }
            i++;
            binNum = binNum >> 1;
        }
        return total;
    }


    /**
     * Take the string version of a binary number and 
     * returns the decimal equivalent.
     * @param s The binary number in string format
     * @return The decimal version of the given binary string
     */
    public static double binaryStringToDecimal(String s) {
        double total = 0.0 ;
        boolean hasDecimal = false;
        int indexOfDecimal = 0;

        if (s.contains(".")) {
            hasDecimal = true;
            indexOfDecimal = s.indexOf('.');
        }

        // find the total of numbers before decimal
        int i = 0;
        int j = (indexOfDecimal == 0) ? 0 : indexOfDecimal-1;
        for (; j>=0; j--) {
            char bitAt = s.charAt(j); //check if bit is set at place i
            if (bitAt == '1') {
                total += Math.pow(2, i);
            }
            i++;
        }


        //find numbers after decimal if any
        if (hasDecimal) {
            int k = indexOfDecimal+1;
            int n = -1;
            while (k < s.length()) {
                total += Math.pow(2, n);
                n--;
                k++;
            }
        }
        return total;
    }

}
