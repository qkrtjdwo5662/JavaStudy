import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2138 {
    static int n;
    static boolean[] now;
    static boolean[] target;
    static int answer;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        now = new boolean[n];
        target = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '1') now[i] = true;
        }

        st = new StringTokenizer(br.readLine());
        s = st.nextToken();

        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '1') target[i] = true;
        }
        answer = 987654321;
        flag = false;
        dfs(0, -1);
    }
    static boolean isEqual(){
        for (int i = 0; i < n; i++) {
            if(now[i] != target[i]) return false;
        }

        return true;
    }
    static void dfs(int depth, int prev){
        if(flag) return;

        if(isEqual()){
            answer = Math.min(answer, depth);
            System.out.println(depth);
            flag = true;
            return;
        }


        for (int i = 0; i < n; i++) {
            if(i == prev) continue;

            if(i == 0){
                now[0] = !now[0];
                now[1] = !now[1];
                dfs(depth + 1, i);
                now[0] = !now[0];
                now[1] = !now[1];

            }else if(i == n-1){
                now[n-2] = !now[n-2];
                now[n-1] = !now[n-1];
                dfs(depth + 1, i);
                now[n-2] = !now[n-2];
                now[n-1] = !now[n-1];
            }else{
                now[i-1] = !now[i-1];
                now[i] = !now[i];
                now[i + 1] = !now[i + 1];
                dfs(depth + 1, i);
                now[i-1] = !now[i-1];
                now[i] = !now[i];
                now[i + 1] = !now[i + 1];
            }
        }

    }
}
