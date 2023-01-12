import java.util.Scanner;

public class N_11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int array[] = new int[N+1];

        array[0] = 0;
        for(int i=1; i<array.length; i++){
            array[i] = array[i-1]+ sc.nextInt();
        }
        for(int i=0; i<M; i++){
            int start = sc.nextInt();
            int end= sc.nextInt();
            System.out.println(array[end]-array[start-1]);
        }


    }
}
