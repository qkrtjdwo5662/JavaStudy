import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_10971 {
    public static int n;
    public static boolean[] visited;
    public static int[][] map;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n];
        answer = Integer.MAX_VALUE;
        dfs(0, "");
        System.out.println(answer);
    }

    public static void dfs(int depth, String s){
        if(depth == n){
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if(i==n-1 && map[s.charAt(i) - '0'][s.charAt(0)-'0']!=0){
                    sum = sum + map[s.charAt(i) - '0'][s.charAt(0)-'0'];
                }else if(i!=n-1 && map[s.charAt(i)-'0'][s.charAt(i+1)-'0']!=0){
                    sum = sum + map[s.charAt(i)-'0'][s.charAt(i+1)-'0'];
                }else return;
            }
            answer = Math.min(answer, sum);

            return;
        }


        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1, s+i);
                visited[i] = false;
            }
        }
    }
}
