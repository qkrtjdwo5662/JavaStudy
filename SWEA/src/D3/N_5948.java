package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class N_5948 {
    public static TreeSet<Integer> treeSet;
    public static int[] arr;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            treeSet = new TreeSet<>();
            arr = new int[7];

            for (int j = 0; j < 7; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[j] = num;
            }

            visited = new boolean[7];
            int answer = 0;
            dfs(0, 0);
            for (int j = 0; j < 5; j++) {
                answer = treeSet.pollLast();
            }

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int depth, int now){
        if(depth == 3){
            treeSet.add(now);
            return;
        }


        for (int i = 0; i < 7; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1, now + arr[i]);
                visited[i] = false;
            }
        }
    }


}
