package src.easy;

/**
 *  Squares of a Sorted Array
 *  https://leetcode.com/squares-of-a-sorted-array
 * 
 *  level: easy
 *  ans: use two pointers on either side of array. compare the square of each pointer and 
 *       fill the sequares array from biggest int to smallest.
 */
public class SquaresOfSortedArray {

    public static void main(String[] args) {
        int[] ans = sortedSquares(new int[]{-7,-3,2,3,11});
        for (int i: ans) {
            System.out.printf("%d | ", i);
        }
    }


    public static int[] sortedSquares(int[] nums) {
        
        // create 2 pointers for each side of array
        int left = 0, right = nums.length - 1;

        // create new array to house squares
        int[] squares = new int[nums.length];

        int sqItr = squares.length-1;
        
        // Since a squared negative can make a positive, we want to make sure that
        //  the positives from a sqaured negative is compared with the largest 
        //  square positive (which occurs at the end of the array)
        while (left <= right) {
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];

            // negative produced a larger square
            if (leftSq > rightSq) {
                squares[sqItr] = leftSq;
                left++;
            } 
            else {
                squares[sqItr] = rightSq;
                right--;
            }
            sqItr--;
        }
        return squares;
    }
    
}
