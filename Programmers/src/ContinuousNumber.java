import java.util.Arrays;
import java.util.Scanner;

public class ContinuousNumber {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        System.out.println(Arrays.toString(solution(n, t)));
    }
    static int[] solution(int n, int t){
        int[] answer = new int[n];
        int avg = t / n;
        int center;
        if(n%2==0){
            center = n/2-1;
        }else{
            center = n/2;
        }



        for (int i =0; i<=center; i++) {
            answer[i]= avg-(center-i);
        }
        for (int i =center+1; i<n; i++) {
            answer[i] = avg+(i-center);
        }
        return answer;
    }
}
