import java.util.Scanner;

public class Array_Solution10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[][] = new int[n+2][n+2];
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                array[i+1][j+1] = sc.nextInt();
            }
        }
        //
        for(int i=0; i<n+2; i++){
            array[0][i] = 0;
            array[i][0] = 0;
            array[n+1][i] = 0;
            array[i][n+1] = 0;
        }


        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(array[i+1][j+1]>array[i+2][j+1] && array[i+1][j+1]>array[i+1][j+2]
                && array[i+1][j+1]>array[i][j+1] && array[i+1][j+1]>array[i+1][j]){
                    count ++;
                }
            }
        }
        System.out.print(count);
    }
}
