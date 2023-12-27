package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RockPaperScissors {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        String answer = rps(A, B);
        System.out.println(answer);

    }

    static String rps(int A, int B){
        if(A < B){
            if(B-A == 1){
                return "B";
            }else return "A";
        }else if(A > B){
            if(A-B == 1){
                return "A";
            }else return "B";
        }else return "";

    }
}
