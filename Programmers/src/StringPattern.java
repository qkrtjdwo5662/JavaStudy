import java.util.Scanner;

public class StringPattern {
    public String solution(int n){
        String answer ="";
        for(int i=1; i<=n; i++){
            if(i%2==0){
                answer= answer+"박";
            }else answer = answer+"수";
        }


        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringPattern sp = new StringPattern();
        int n = sc.nextInt();
        System.out.print(sp.solution(n));
    }
}
