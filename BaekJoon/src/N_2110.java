import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_2110 {
    static int N;
    static int C;
    static int[] arr;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        answer = 0;
        Arrays.sort(arr);
        backtrack(0, 987654321, 0, 0);

        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void backtrack(int depth, int min, int now, int index){
        if(depth == C){
            answer = Math.max(answer, min);
            return;
        }

        for (int i = index; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                if(depth != 0){
                    backtrack(depth + 1, Math.min(min, arr[i] - now), arr[i], i);
                }else backtrack(depth + 1, min, arr[i], i);
                visited[i] = false;
            }
        }
    }
}
