package src.broken;
public class BinomialCoefficients {

    public static void main(String[] args){

        System.out.print( "The value of C(5, 2) is => " + binomialCoefficents(5, 2) ); //choose 2 things out of 5 possibilites
    }

    // Returns value of Binomial Coefficient C(n, k)
    public static long binomialCoefficents(int n, int k){
        int i, j;

        long[][] bc = new long [n+1][n+1];

        for(i=0; i<=n; i++) bc[i][0] = 1;

        for(j=0; j<=n; j++) bc[j][j] = 1;

        for(i=1; i<=n; i++) {
            for(j=1; j<=i; j++) {
                System.out.println("i: " + i + ", j: " + j);
                bc[i][j] = bc[i-1][j-1]+ bc[i-1][j];
                System.out.println("bc[" + i + "][" + j + "] {="+ bc[i][j] + "} = bc[" + (i-1) + "][" + (j-1) + "] {= "+ bc[i-1][j-1]+"} + bc[" + (i-1) + "][" + (j) + "] {= "+ bc[i-1][j]+"}\n\n" );
            }
        }

        return bc[n][k];
    }
}
