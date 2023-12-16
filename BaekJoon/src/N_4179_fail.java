import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_4179_fail {
    public static int n;
    public static int m;
    public static char[][] board;
    public static int[] ry = {1, -1, 0, 0};
    public static int[] rx = {0, 0, 1, -1};
    public static int answer;
    public static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        int[] start = new int[2];
        ArrayList<int[]> fireList = new ArrayList<>();

        answer = 0;
        check = false;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for (int j = 0; j < m; j++) {
                if(s.charAt(j) == 'J'){
                    start = new int[]{i, j};
                }else if(s.charAt(j) == 'F'){
                    fireList.add(new int[]{i, j});
                }
                board[i][j] = s.charAt(j);
            }
        }
        bfs(start, fireList);
        if(!check){
            sb.append("IMPOSSIBLE").append("\n");
        }
        System.out.println(sb);

    }

    public static void bfs(int[] start, ArrayList<int[]> fireList){
        int[][] distance = new int[n][m];
        boolean[][][] visited = new boolean[n][m][2];

        ArrayDeque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < fireList.size() ; i++) {
            int[] fire = fireList.get(i);
            deque.addLast(new int[]{fire[0], fire[1], 1});
            visited[fire[0]][fire[1]][1] = true;
        }

        deque.addLast(new int[]{start[0], start[1], 0}); // 지훈 0
        visited[start[0]][start[1]][0] = true;
        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r < 0 || c<0 || r>= n || c>= m) continue;

                if(board[r][c] == '#') continue;

                if(now[2] == 0){ // 지훈
                    if(!visited[r][c][0]){
                        visited[r][c][0] = true;
                        deque.addLast(new int[]{r, c, 0});
                        distance[r][c] = distance[now[0]][now[1]] + 1;

                        if(r == n-1 || r==0 || c== m-1 || c== 0){
                            System.out.println(distance[r][c] + 1);
                            check = true;
                            return;
                        }
                    }


                }else{ // 불
                    if(!visited[r][c][1]){
                        visited[r][c][1] = true;
                        visited[r][c][0] = true;
                        deque.addLast(new int[]{r, c, 1});
                    }
                }
            }
        }

    }
}
