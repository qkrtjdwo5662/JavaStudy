import java.util.Scanner;

public class N_1204 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int max = 0;
        int s =0;
        int n = sc.nextInt();
        int []m = new int[n];
        int []score = new int[101];
        for(int i=0; i<m.length; i++){
            m[i] = sc.nextInt();
        }
        for(int i=0; i<m.length; i++){
            score[m[i]]++;
        }
        for(int i=score.length-1; i>-1; i--){
            if(max<score[i]) {
                max = score[i];
                s = i;
            }
        }
        for(int i=0; i<score.length; i++){
            System.out.println(i+" : "+score[i]);
        }
        System.out.println();
        System.out.println("최빈수 : " + s);
    }
}
