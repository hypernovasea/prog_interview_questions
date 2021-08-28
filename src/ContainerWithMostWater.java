package src;

/**
 *  Container With Most Water
 *  https://leetcode.com/problems/container-with-most-water/
 *
 *  level: medium
 *  ans: sliding window
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.printf("container with most water: %d\n", maxArea(height));
    }

    public static int maxAreaBruteForce(int[] height) {
        /**
         * Brute force method: compare each point with another, determine the height
         * by grabbing the smallest value and times it by the distance between
         * both points.
         */
        int max = 0;
        for (int i=0; i<height.length-1; i++) {
            for (int j=i+1; j<height.length; j++) {
                // container height determined by smaller height
                int smallerHeight = Math.min(height[i], height[j]);

                // length = (point j - point i)
                int maxPossibleHeight = smallerHeight * (j-i);
                max = Math.max(max, maxPossibleHeight);
            }
        }
        return max;
    }

    public static int maxArea(int[] height) {
        // we know that getting the max arrea is determined by getting the
        // tallest height * the longest width. the longest width is, at most
        // the length of the array (from index 0 to array.length-1). the tallest
        // height would be the "shortest" tallest height available.
        // perhaps use a sliding window technique. start from opposite ends of the
        // array and increment / decrement indices based on whoever is pointing to the
        // smallest height. for example if height[i]=1 and height[j]=7, increment i since
        // it's the shorter height.

        int i = 0, j = height.length-1;  // window indices
        int max = 0;
        while (i < j) {
            // formula --> min(height[i], height[j]) * (j-1)
            int area = Math.min(height[i], height[j]) * (j-i);
            max = Math.max(max, area);

            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return max;
    }
}