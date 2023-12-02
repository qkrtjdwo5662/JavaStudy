package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_3234 {
//    public static int n;
//    public static int[] arr;
//    public static boolean[] visited;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            boolean[] visited = new boolean[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[j] = num;
            }
            answer = 0;
            dfs(0, 0, 0, arr, visited, n);
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int depth, int left, int right, int[] arr, boolean[] visited, int n){
        if(depth == n){
            if(left >= right) {
                answer++;
            }
            return;
        }

        if(left < right) return;

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(depth + 1, left + arr[i], right, arr, visited, n);
                if(left >= right + arr[i]){
                    dfs(depth + 1, left, right + arr[i], arr, visited, n);
                }
                visited[i] = false;
            }
        }
    }
}
