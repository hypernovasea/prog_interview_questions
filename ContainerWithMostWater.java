
/**
 *  Container With Most Water
 *  https://leetcode.com/problems/container-with-most-water/
 *
 *  level: medium
 *  ans:
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.printf("container with most water: %d\n", maxArea(height));
    }

    public static int maxArea(int[] height) {


        /**
         * Brute force method: comapre each point with another and times it
         * by the distance.
         */
        for (int i=0; i<height.length-1; i++) {
            for (int j=i+1; j<height.length; j++) {


            }
        }

        return -1;
    }
}