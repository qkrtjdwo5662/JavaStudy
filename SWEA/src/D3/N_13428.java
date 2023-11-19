package D3;

import java.util.*;
import java.io.*;

public class N_13428{
    public static int n;
    public static boolean[] visited;
    public static int max;
    public static int min;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for(int i=1; i<= tc; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            n = s.length();

            if(n < 2) {
                sb.append("#").append(i).append(" ").append(s + " ").append(s).append("\n");
                continue;
            }

            visited = new boolean[n];


            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            backtrack(0, "", s);

            sb.append("#").append(i).append(" ").append(min + " ").append(max).append("\n");

        }

        System.out.println(sb);

    }
    public static void backtrack(int depth, String now, String s) {
        if(depth == 2) {
            String[] arr = now.split(" ");

            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);

            String[] numArr = s.split("");

            String temp = numArr[a];
            numArr[a] = numArr[b];
            numArr[b] = temp;

            String numString = "";


            for(int i = 0; i<n; i++) {
                numString += numArr[i];
            }


            if(numArr.length==2) {
                numString = numArr[a] + numArr[b];
            }

            int num = Integer.parseInt(numString);

            if(n == String.valueOf(num).length()) {

                min = Math.min(min, num);
                max = Math.max(max, num);
            }else {

                min = Math.min(min,  Integer.parseInt(s));
                max = Math.max(max,  Integer.parseInt(s));
            }


            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;

                if(depth == 0) backtrack(depth+1, now + i, s);
                else backtrack(depth+1, now + " " + i, s);

                visited[i] = false;
            }
        }


    }
}
