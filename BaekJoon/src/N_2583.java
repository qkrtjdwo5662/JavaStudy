import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N_2583 {
    public static int[][] map;
    public static boolean[][] visited;
    public static ArrayList<Integer> arrayList;
    public static int n;
    public static int m;
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2 ; j++) {
                for (int l = x1; l < x2 ; l++) {
                    map[j][l] = 1;
                }
            }
        }
        visited = new boolean[n][m];
        arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]==0 && !visited[i][j]){
                    bfs(new int[]{i,j});
                }
            }
        }
        Collections.sort(arrayList);

        System.out.println(arrayList.size());

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }

    }
    public static void bfs(int[] start){
        int count = 1;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        
        deque.addLast(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;
        
        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r<0 || c<0 || r>=n || c>=m) continue;

                if(map[r][c] != 0) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[] {r,c});
                    count = count+1;
                }
            }
        }

        arrayList.add(count);
    }
}
