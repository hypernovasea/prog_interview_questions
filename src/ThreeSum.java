package src;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  3Sum
 *  https://leetcode.com/problems/3sum/
 *
 *  level: medium
 *  ans: sorting, two pointers
 *
 */
public class ThreeSum {

    public static void main(String[] args) {
        List<List<Integer>> sums = threeSum(new int[]{-1,0,1,2,-1,-4});
        printSums(sums);
    }


    /**
    *   Basic Solution: After sorting the array, you now know where the numbers are and
    *                   how they affect the sum. Take three indices, one at index i, one
    *                   after index i, at i+1, and one index at the end. If the sum of these
    *                   three indices add up to 0, then add to list. If sum is > 0, decrease
    *                   the end index since we know that no number after it will produce 0. If
    *                   the sum is < 0, increase the start since we know that no number before
    *                   it will produce 0.
    */
    public static List<List<Integer>> threeSum(int[] nums) {

        // this uses quicksort (since it's an array of primitives) so n * log n
        // this puts the integers where we need them to be: positives on one side
        // and the negatives on the other.
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        // iterate thru array since start pointer is
        //  1 ahead of i and end pointer is 2 ahead of i.
        for (int i=0; i<nums.length-2; i++) {

            // avoid any duplicates that have occured previously
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int start = i+1;    // start after the current i
            int end = nums.length-1;    // start at end

            while (start < end) {
                // found a 0 sum so add to list
                if (nums[i] + nums[start] + nums[end] == 0) {
                    ans.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[start], nums[end])));

                    // move pointers
                    start++;
                    end--;

                    // avoid duplicates from either pointers
                    while ( start < end && nums[start] == nums[start-1])
                        start++;

                    while( start < end && nums[end] == nums[end+1])
                        end--;
                }

                // less than 0, increment start until next
                //  greatest value is found
                else if( nums[i] + nums[start] + nums[end] < 0) {
                    int currStart = start; //start++;
                    while(start < end && nums[start] == nums[currStart]) {
                        start++;
                    }
                }

                // sum is greater than 0 so decrement end until next
                //  unique value is found
                else {  //(nums[i] + nums[start] + nums[end] > 0){
                    int currEnd = end; //end--;
                    while(start < end && nums[end] == nums[currEnd]) {
                        end--;
                    }
                }
            }
        }
        return ans;
    }


    public static void printSums(List<List<Integer>> sums) {
        for (List<Integer> list: sums) {
            for (int i : list) {
                System.out.printf("%d ", i);
            }
            System.out.println("");
        }
    }
}
