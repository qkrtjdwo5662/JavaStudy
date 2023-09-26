import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N_16562_2 {
    public static int[] parent;
    public static int[] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 학생 수
        int m = Integer.parseInt(st.nextToken()); // 친구관계 수
        int k = Integer.parseInt(st.nextToken()); // 가진돈

        cost = new int[n+1];
        parent = new int[n+1];

        for (int i = 1; i <= n ; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n ; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        HashSet<Integer> set  =new HashSet<>();
        for (int i = 1; i <= n ; i++) {
            set.add(find(i));
        }

        int answer = 0;
        for (int key : set) {
            answer = answer + cost[key];
        }

        if(answer> k) System.out.println("Oh no");
        else System.out.println(answer);
    }


    public static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        if(cost[x]>cost[y]) parent[x] = y;
        else parent[y] = x;
    }

    public static int find(int a){
        if(parent[a] == a) return parent[a];

        return parent[a] = find(parent[a]);
    }
}
