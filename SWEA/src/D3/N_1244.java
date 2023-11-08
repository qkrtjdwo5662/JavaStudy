package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1244 {
    public static String[] arr;
    public static int count;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            arr = st.nextToken().split("");
            count = Integer.parseInt(st.nextToken());

            if(arr.length < count ) count = arr.length;
            answer = 0;
            backtrack(0, 0);

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);

    }

    public static void backtrack(int start, int nowCount){
        if(nowCount == count){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }
            answer = Math.max(answer, Integer.parseInt(String.valueOf(sb)));
            return;
        }

        for (int i = start; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                backtrack(i , nowCount+1);

                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
    }

}
