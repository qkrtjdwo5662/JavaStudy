import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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


            dfs(0, "", 0, n);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int sum, String s, int count ,int n){
        if(sum > n) return;

        if(sum == n){
            String[] arr = s.split(" ");
            Arrays.sort(arr);
            StringBuilder sbb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sbb.append(arr[i]);
            }
            if(!set.contains(sbb.toString())) {
                set.add(sbb.toString());
                answer += 1;
            }
            return;
        }

        if(count == 0){
            dfs(1, "1", 1, n);
            dfs(2, "2", 1, n);
            dfs(3, "3", 1, n);
        }else{
            dfs(sum + 1, s+" "+1, count+1, n);
            dfs(sum + 2, s+" "+2, count+1, n);
            dfs(sum + 3, s+" "+3, count+1, n);
        }
    }
}


// set<int[]>로 사용하면 주솟값 일치여부로 확인함