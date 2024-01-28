import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_12865_fail {
    static int[] weights;
    static int[] values;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 물품 수
        int k = Integer.parseInt(st.nextToken()); // 제한 무게

        weights = new int[n];
        values = new int[n];

        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            weights[i] = w;
            values[i] = v;
        }
        answer = 0;
        dfs(0, 0, 0, n, k);
        System.out.println(answer);
    }

    static void dfs(int nowWeight, int nowValue, int index, int n, int k){
        if(nowWeight > k){
            return;
        }

        answer = Math.max(answer, nowValue);

        if(index == n) return;

        dfs(nowWeight + weights[index], nowValue + values[index], index + 1, n, k);
        dfs(nowWeight, nowValue, index + 1, n, k);
    }
}
