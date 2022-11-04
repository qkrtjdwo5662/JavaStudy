import java.util.Scanner;

public class N_1954 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[][] = new int[n][n];

        for(int i=1; i<=n*n; i++){
            for(int j=0; j<array.length; j++){
                array[0][j] = j;
                array[j][0] = j;
                
            }

        }
    }
}
