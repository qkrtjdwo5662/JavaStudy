package D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_1247 {
    public static int answer;
    public static int n;
    public static boolean[] visited;
    public static ArrayList<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int[] office = new int[2];
            int[] house = new int[2];
            for (int j = 0; j < n + 2; j++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if(j == 0) {
                    office = new int[]{x, y};
                    continue;
                }

                if(j == 1){
                    house = new int[]{x, y};
                    continue;
                }

                list.add(new int[]{x, y});
            }
            visited = new boolean[n];
            answer = Integer.MAX_VALUE;
            dfs(office, 0, 0, house);
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int[] now, int sum, int count, int[] house){
        if(sum > answer) return;

        if(count == n){
            int diff = Math.abs(now[0] - house[0]) + Math.abs(now[1] - house[1]);
            answer = Math.min(answer, sum + diff);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                int[] point = list.get(i);
                int diff = Math.abs(now[0] - point[0]) + Math.abs(now[1] - point[1]);
                visited[i] = true;
                dfs(point, sum + diff, count + 1, house);
                visited[i] = false;
            }
        }

    }
}
