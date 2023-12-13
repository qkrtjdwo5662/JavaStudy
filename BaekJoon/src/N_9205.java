import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_9205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

//            int[][] board = new int[32768 + 32767 + 1][32768 + 32767 + 1];

            int n = Integer.parseInt(st.nextToken()); // 편의점 수

            ArrayList<int[]> list = new ArrayList<>(); // 편의점 좌표 담아줄 list

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int[] start = new int[]{x, y};

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                list.add(new int[]{x, y});
            }
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int[] end = new int[]{x, y};

            if(bfs(start, end, list)){
                sb.append("happy").append("\n");
            }else sb.append("sad").append("\n");

        }
        System.out.println(sb);
    }

    public static boolean bfs(int[] start, int[] end, ArrayList<int[]> list){
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        int n = list.size();
        boolean[] visited = new boolean[n];
        deque.addLast(start);

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            if(Math.abs(now[0] - end[0]) + Math.abs(now[1] - end[1]) <= 1000){
                return true;
            }

            for (int i = 0; i < n; i++) {
                if(!visited[i]){
                    int nx = list.get(i)[0];
                    int ny = list.get(i)[1];

                    int distance = Math.abs(now[0] - nx) + Math.abs(now[1] - ny);

                    if(distance <= 1000){
                        visited[i] = true;
                        deque.addLast(new int[]{nx, ny});
                    }
                }
            }
        }

        return false;
    }
}


// 시작점, 목표점, 편의점 좌표 분리
// 편의점 좌표는 list에 담고,

// 시작점으로 부터 bfs
// queue에서 꺼내서 해당 좌표가 목표좌표까지의 거리가 1000 이하면 도달 가능 return true
// list 탐색해서 편의점 좌표 하나씩 탐색하는데
// 현재 거리에서 편의점까지의 거리가 1000 이하면 queue에 넣고 방문처리