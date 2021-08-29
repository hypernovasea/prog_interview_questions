package src.easy;

/**
 *  Find the Missing Number
 *  https://www.educative.io/courses/grokking-the-coding-interview/JPnp17NYXE9
 * 
 *  level: easy
 *  ans: use cyclic sort
 */
public class FindTheMissingNumber {
    
    public static void main(String[] args) {
        int[] arr = new int[] {4, 0, 3, 1};
        System.out.println(findTheMissingNum(arr));
    }


    public static int findTheMissingNum(int[] nums) {

        // each number, x, has to match up with its correct cell at
        //  x. if it doesn't, swap it. if swapping doesn't work,
        //  then x is the missing number
        int i = 0;
        while (i < nums.length) {
            // check if number is at correct position
            // num i is not in correct position and is within array bounds
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            } else {
                // nums[i] is in position so move on
                i++; 
            }
        }

        // find missing number
        for (i=0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }

        return nums.length;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
