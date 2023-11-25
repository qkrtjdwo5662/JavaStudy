package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_11285 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int answer = 0;
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                answer += score(x, y);
            }

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static int score(int x, int y){
        int answer = 0;

        int sumSquare = (int)Math.pow(x, 2) + (int)Math.pow(y, 2);

        int sqrt = (int)Math.sqrt(sumSquare);

        if(sqrt >= 0 && sqrt<=20){
            answer = 10;
        } else if (sqrt > 20 && sqrt<=40) {
            answer = 9;
        }else if(sqrt > 40 && sqrt<=60){
            answer = 8;
        }else if(sqrt > 60 && sqrt<=80){
            answer = 7;
        }else if(sqrt > 80 && sqrt<=100){
            answer = 6;
        }else if(sqrt > 100 && sqrt<=120){
            answer = 5;
        }else if(sqrt > 120 && sqrt<=140){
            answer = 4;
        }else if(sqrt > 140 && sqrt<=160){
            answer = 3;
        }else if(sqrt > 160 && sqrt<=180){
            answer = 2;
        }else if(sqrt > 180 && sqrt<=200){
            answer = 1;
        }

        return answer;
    }
}
