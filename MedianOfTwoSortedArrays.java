
/**
 *  Median of Two Sorted Arrays
 *  https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 *  level: hard   
 *  ans: Find median by "partitioning" both arrays into right and left so
 *      that a divide can be made where left side of both arrays is less than the right 
 *      sides of both arrays 
 *              nums1 -> {1,3,8,9,15}
 *              nums2 -> {7,11,18,19,21,25}
 *              after partitioning -> 1,3 | 8,9,15
 *                                      7 | 11,18,19,21,25
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {

		int[] nums1 = {4,6,8,9,10,11};
		int[] nums2 = {2,5,7,9,13};
		
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}


	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //initialize int as combined length of both arrays 
		int length= nums1.length + nums2.length;
		
		//create an array that will hold ints from both arrays
        int[] all = new int[length];
        
        //check if lengths of either array is greater than zero
        boolean adddedAllN1 = (nums1.length == 0 ? true : false);
        boolean adddedAllN2 = (nums2.length == 0 ? true : false);
        
        //initialize counters for each array
        int count1 = 0;
        int count2 = 0;
        
        //for 0 to the combined length of both arrays
        for(int i=0; i < length; i++) {
        	
        	//if the length of both arrays are greater than 0
            if(!adddedAllN1 && !adddedAllN2) {
            	
            	//if num in second array is greater than num in first array
                if(nums1[count1] <  nums2[count2]) {
                	
                	//set the current index to the first num and increment 
                	// counter of the first array
                    all[i] = nums1[count1++];
                    
                    //check if we've reached the boundaries of first array
                    adddedAllN1 = (count1 == nums1.length ? true : false);
                } 
                //if num in second array is less than or equal to num in first array
                else {
                	
                	//set the current index to the second num and increment 
                	// counter of the second array
                    all[i] = nums2[count2++];
                    
                    //check if the boundaries of the second array have been reached
                    adddedAllN2 = (count2 == nums2.length ? true : false);
                }
                
            } 
            //if the first array has a length of 0
            else if(adddedAllN1) {
            	
            	//set the current index to the num in second array and 
            	// increment second array counter
                all[i] = nums2[count2++];
            } 
            //if the second array has a length of 0
            else {
            	
            	//set the current index to the num in the first array and 
            	// increment first array counter
                all[i] = nums1[count1++];
            }
        }
        
        //if the combined length of the arrays is even
        if(length % 2 == 0) {
        	
        	//calculte the middle of the array
            return (double) (all[length/2] + all[(length/2) - 1])/2;
        } else {
        	
        	//return the middle index of the array
            return all[(int)Math.floor(length/2)];
        }
    }

}
