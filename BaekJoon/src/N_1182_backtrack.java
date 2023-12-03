import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1182_backtrack {
    public static int n;
    public static int s;
    public static int[] arr;
    public static boolean[] visited;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        answer = 0;
        backtrack(0, 0);
        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    public static void backtrack(int depth, int sum){
        if(depth == n){
            return;
        }

        if(sum == s){
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                if(sum + arr[i] <= sum){
                    backtrack(depth + 1, sum + arr[i]);
                }
                visited[i] = false;
            }
        }
    }
}
