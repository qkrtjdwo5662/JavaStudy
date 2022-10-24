import java.util.Scanner;

public class N_1206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count =0;
        int array[][] = new int[N + 4][256];
        for(int i=0; i<array[0].length; i++){
            array[0][i] = sc.nextInt();
        }
        for (int i = 2; i < array.length - 1; i++) {
            for (int j = 0; j < array[0][i]; i++) {
                array[i][j] = 1;
            }
        }
    }
}
