package src.medium;

/**
 *  Rotate Image
 *  https://leetcode.com/problems/rotate-image/
 * 
 *  level: medium
 *  ans: array manipulations => transpose the array on diagonal and 
 *          then reverse each row from left to right.
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] image1 = new int[][]{
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        printImage(image1);
        rotate(image1);
        printImage(image1);
    }

    public static void rotate(int[][] matrix) {
        
        // transpose matrix one diagonal going from top left corner
        //  to the bottom right corner
        for(int i=0; i<matrix.length; i++) {
            for(int j=i; j<matrix[0].length; j++) {
                swap(matrix, j, i, i, j);
            }
        }
        
        // reverse rows
        for(int row=0; row<matrix.length; row++){
            int startCol=0;
            int endCol=matrix.length-1;
            while(startCol < endCol) {
                swap(matrix, row, startCol, row, endCol);
                startCol++;
                endCol--;
            }
        }
    }
    

    public static void swap(int[][] matrix, int aRow, int aCol, int bRow, int bCol){
        int tmp = matrix[aRow][aCol];
        matrix[aRow][aCol] = matrix[bRow][bCol];
        matrix[bRow][bCol] = tmp;
        
    }
    

    public static void printImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.printf("%d | ", image[i][j]);
            }
            System.out.println();
        }
    }
}
