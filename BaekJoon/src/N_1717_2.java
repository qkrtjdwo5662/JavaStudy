import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1717_2 {
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for (int i = 0; i <= n ; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(operation == 0){
                union(a, b);
            }else if(operation == 1){
                if(find(a) == find(b)) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }

        System.out.print(sb);
    }

    public static void union(int a, int b){
        int x = find(a); // x는 a의 부모노드
        int y = find(b); // y는 b의 부모노드

        parent[x] = y;
    }
    public static int find(int a){
        if(parent[a] == a) return parent[a];

        return parent[a] = find(parent[a]);
    }
}
