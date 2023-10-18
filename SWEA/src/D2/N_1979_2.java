package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1979_2 {
    public static int n;
    public static int k;
    public static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[n][n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < n; l++) {
                    int num = Integer.parseInt(st.nextToken());
                    map[j][l] = num;
                }
            }

            int answer = countRow() + countColumn();

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static int countRow(){
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1) count++;

                else if(map[i][j] == 0 && count >0){
                    if(count == k) answer++;
                    count = 0;
                }
            }
            if(count == k) answer++;
        }


        return answer;
    }

    public static int countColumn(){
        int answer =0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(map[j][i] == 1) count++;

                else if(map[j][i] == 0 && count > 0){
                    if(count == k) answer++;
                    count = 0;
                }
            }
            if(count == k) answer++;
        }
        return answer;
    }
}
