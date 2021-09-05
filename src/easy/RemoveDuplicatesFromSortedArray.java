package src.easy;

/**
 *  Remove Duplicates From Sorted Array
 *  https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 *  level: easy
 *  ans: use two pointers. One pointer iterates thru the array and the other 
        holds the position of the next cell to fill. 
 *  
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int ans = removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4});
        System.out.printf("ans: %d\n", ans);
    }

    
    public static int removeDuplicates(int[] nums) {
        
        int nextNonDuplicate = 1;
        
        for(int i=1; i<nums.length; i++) {
            
            // If the two cell values are the same, nextNonDuplicate 
            // will remain until the next distinct number is found.
            if(nums[nextNonDuplicate-1] != nums[i]) {
                nums[nextNonDuplicate] = nums[i];
                nextNonDuplicate++;
            }
        }
        
        return nextNonDuplicate; 
    }
    
}
