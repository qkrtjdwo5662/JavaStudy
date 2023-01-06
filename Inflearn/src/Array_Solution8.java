import java.util.Scanner;

public class Array_Solution8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int score[] = new int[N];
        int rank[] = new int[N];

        int count = 1;
        for(int i=0; i<score.length; i++){
            score[i] = sc.nextInt();
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(score[i]<score[j]){
                    count++;
                }
                rank[i] = count;
                count = 1;
            }
        }
        for(int i=0; i<N; i++){
            System.out.print(rank[i] + " ");
        }


    }
}
