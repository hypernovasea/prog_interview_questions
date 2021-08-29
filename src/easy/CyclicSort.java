package src.easy;


/**
 *  Cyclic Sort
 *  https://www.educative.io/courses/grokking-the-coding-interview/B8qXVqVwDKY
 * 
 *  level: easy
 *  ans: since each number is unique and ranges from 1 to n, try to each 
 *          number at its rightful index (n-1).
 */
public class CyclicSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 5, 4, 2 };
        sort(arr);
        for (int num : arr)
          System.out.print(num + " ");
        System.out.println();
    
        arr = new int[] { 2, 6, 4, 3, 1, 5 };
        sort(arr);
        for (int num : arr)
          System.out.print(num + " ");
        System.out.println();
    
        arr = new int[] { 1, 5, 6, 4, 3, 2 };
        sort(arr);
        for (int num : arr)
          System.out.print(num + " ");
        System.out.println();
      }

    
    public static void sort(int[] nums) {
      int i = 0;
      while (i < nums.length) {
        // get the correct index of current number
        int j = nums[i] - 1;

        // if the current number isn't in its rightful cell, swap
        if (nums[i] != nums[j])
          swap(nums, i, j);
        else
          i++;  // number is in the right place, increment index
      }
    }


    private static void swap(int[] arr, int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }

  }