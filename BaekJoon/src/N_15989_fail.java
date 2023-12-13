import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N_15989_fail {
    public static int answer;
    public static HashSet<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            answer = 0;
            set = new HashSet<>();


            dfs(1, "1", 1, n);
            dfs(2, "2", 2, n);
            dfs(3, "3", 3, n);

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int sum, String s, int now ,int n){
        if(sum > n) return;

        if(sum == n){
            if(!set.contains(s)) {
                set.add(s);
                answer += 1;
            }
            System.out.println(set);
            return;
        }

        for (int i = now; i <= 3; i++) {
            if(sum+i <= n){
                dfs(sum+i, s+i, i, n);
            }
        }

//        if(count == 0){
//            dfs(1, "1", 1, n);
//            dfs(2, "2", 1, n);
//            dfs(3, "3", 1, n);
//        }else{
//            dfs(sum + 1, s+" "+1, count+1, n);
//            dfs(sum + 2, s+" "+2, count+1, n);
//            dfs(sum + 3, s+" "+3, count+1, n);
//        }
    }
}


// set<int[]>로 사용하면 주솟값 일치여부로 확인함