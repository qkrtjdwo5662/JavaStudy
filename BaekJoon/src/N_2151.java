import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_2151 {
    static class Info{
        int y;
        int x;
        int d; // 방향
        int count; // 문 설치 개수

        public Info(int y, int x, int d, int count){
            this.y = y;
            this.x = x;
            this.d = d;
            this.count = count;
        }
    }

    static int n;
    static char[][] map;
    static int[] ry = {-1, -1, 1, 1};
    static int[] rx = {-1, 1, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        map = new char[n][n];

        List<int[]> door = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                map[i][j] = c;

                if(c == '#') door.add(new int[]{i, j});
            }
        }

        int answer = dijkstra(door.get(0)[0], door.get(0)[1], door.get(1)[0], door.get(1)[1]);
        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static int dijkstra(int sy, int sx, int ey, int ex){
        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.count, o2.count);
        });
        pq.add(new Info(sy, sx, -1, 0));

        while(!pq.isEmpty()){
            Info now = pq.poll();

            int ny = now.y;
            int nx = now.x;
            int nd = now.d;
            int nc = now.count;

            if(ny == ey && nx == ex) return nc;

            if(nd == -1){ // 방향이 없다면
                for (int i = 0; i < 4; i++) {
                    int r = ny + ry[i];
                    int c = nx + rx[i];

                    if(r < 0 || r >= n || c < 0 || c>= n) continue;

                    if(map[r][c] == '*') continue;

                    pq.add(new Info(r, c, i, nc));
                }
            }else{ // 방향이 있다면
                if(map[ny][nx] == '.' || map[ny][nx] == '!'){
                    int r = ny + ry[nd];
                    int c = nx + rx[nd];

                    if(r < 0 || r >= n || c < 0 || c>= n) continue;

                    pq.add(new Info(r, c, nd, nc));
                }

                if(map[ny][nx] == '!'){
                    // 45도 회전
                    // 0 -> 1
                    // 1 -> 0

                    // 2 -> 3
                    // 3 -> 2
                    int d = -1;

                    if(nd == 0){
                        d = 1;
                    }else if(nd == 1){
                        d = 0;
                    }else if(nd == 2){
                        d = 3;
                    }else{
                        d = 2;
                    }

                    int r = ny + ry[d];
                    int c = nx + rx[d];

                    if(r < 0 || r >= n || c < 0 || c>= n) continue;

                    pq.add(new Info(r, c, d, nc + 1));
                }
            }

        }

        return -1;
    }
}
