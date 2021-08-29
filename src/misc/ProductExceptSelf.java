package src.misc;

import java.util.Arrays;


public class ProductExceptSelf {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int[] product = productExceptSelf(nums);
		System.out.println(Arrays.toString(product));
	}
	
	public static int[] productExceptSelf(int[] nums) {
        
        int N = nums.length;
        
        if (N == 0 || N == 1)
            return nums;
        
        int[] copy = new int[N];
        
        /*
        int[] copy2 = new int[N];
        
        Arrays.fill(copy1, 1);
        Arrays.fill(copy2, 1);
        
        int prod = 1;
        
        for(int i=1; i<N; i++){
            copy1[i] = copy1[i-1] * nums[i-1];
        }
        
        for(int j=N-2; j>=0; j--){
            copy2[j] = copy2[j+1] * nums[j+1];
        }
        
        for(int k=0; k<N; k++){
            copy1[k] *= copy2[k];
        }
        */
        
        copy[0] = 1;
        
        for (int i=1; i<N; i++) {
            copy[i] = copy[i-1] * nums[i-1];
        }
        
        int right = 1;
        
        for (int j=N-1; j>=0; j--) {
        	copy[j] *= right;
            right *= nums[j];
        }
        
        return copy;
        
    }

}
