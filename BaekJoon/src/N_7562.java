import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_7562 {
    public static int[] rx = {-1, 1, -1, 1, -2, 2, -2, 2};
    public static int[] ry = {2, 2, -2, -2, 1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] start = new int[2];
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] end = new int[2];
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            if(start[0] == end[0] && start[1] == end[1]){ // 시작점 끝점 같으면 0
                sb.append(0).append("\n");
                continue;
            }

            int count = 0;
            boolean[][] visited = new boolean[n][n]; // 방문 체크용
            ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();

            visited[start[0]][start[1]] = true;
            arrayDeque.addLast(new int[]{start[0], start[1]});

            loop:
            while(true){
                int size = arrayDeque.size();
                count++;
                for (int j = 0; j < size; j++) {
                    int[] now = arrayDeque.pollFirst();
                    for (int k = 0; k < 8; k++) {
                        int r = now[0] + ry[k];
                        int c = now[1] + rx[k];

                        if(r == end[0] && c==end[1]){
                            sb.append(count).append("\n");
                            break loop;
                        }

                        if(r<0 || c<0 || r>=n || c>=n){ // 범위 체크
                            continue;
                        }

                        if(!visited[r][c]){
                            visited[r][c] = true;
                            arrayDeque.addLast(new int[]{r,c});
                        }
                    }
                }



            }
        }
        System.out.print(sb);
    }
}
