public class RotateImage {

    public static void main(String[] args) {
        
    }

    public static void rotate(int[][] matrix) {
        
        // Transpose
        for(int i=0; i<matrix.length; i++) {
            for(int j=i; j<matrix[0].length; j++) {
                swap(matrix, j, i, i, j);
            }
        }
        
        
        //Reverse rows
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
    
}
