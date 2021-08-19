import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-watch/
 *
 * Constraints
 * - The hour '12' is represented by 0.
 * - The minute must consist of 2 digits and contain a
 *      leading 0 if min < 10.
 *
 * Ans: Use basic backtracking .
 */


public class BinaryWatch {

    public static void main(String[] args) {

        System.out.println(readBinaryWatch(5).toString());
        System.out.println(readBinaryWatch(1).toString());
        System.out.println(readBinaryWatch(9).toString());
    }

    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> times = new ArrayList<>();
        for (int h=0; h<12; h++) {
            for (int m=0; m<59; m++) {
                if ((Integer.bitCount(h) + Integer.bitCount(m)) == turnedOn) {
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return times;
    }

}
