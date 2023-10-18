import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_14503_2 {
    public static int[][] board;
    public static int[] ry = {-1, 0, 1, 0};
    public static int[] rx = {0, 1, 0, -1};

    public static int answer;

    public static int n;
    public static int m;
    public static int d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] start = new int[2];

        int r = Integer.parseInt(st.nextToken()); // y좌표
        int c = Integer.parseInt(st.nextToken()); // x좌표
        d = Integer.parseInt(st.nextToken()); // 방향 북, 동, 남, 서

        board = new int[n][m];

        for (int i = 0; i <n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <m ; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }

        start[0] = r;
        start[1] = c;

        answer = 0;

        bfs(new int[]{r,c});
        System.out.println(answer);
    }

    public static void bfs(int[] start){
        ArrayDeque<int[]> deque = new ArrayDeque<>();

        deque.addLast(start);

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();
            boolean flag = false;

            if(board[now[0]][now[1]] == 0) {
                board[now[0]][now[1]] = 2;
                answer ++;
            }else if(board[now[0]][now[1]] == 1){
                return;
            }

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r <0 || c< 0 || r>= n || c>=m ) continue;

                if(board[r][c] == 0) {
                    flag = true;
                    break;
                }
            }
            while (true) {
                if(flag){ // 청소 구역 존재

                    // 반시계 90도 회전
                    if(d <= 0) { // 0 -> 3
                        d = 3;
                    }else{
                        d = d-1;
                    }

                    // 한칸 이동
                    int r=  now[0] + ry[d];
                    int c=  now[1] + rx[d];

                    if(r <0 || c< 0 || r>= n || c>=m ) continue;

                    if(board[r][c] == 0){
                        deque.addLast(new int[]{r,c});
                        break;
                    }

                }else{ // 청소 구역 X

                    // 방향 유지 후퇴
                    int r = now[0] + ry[(d+2)%4];
                    int c = now[1] + rx[(d+2)%4];

                    if(r <0 || c< 0 || r>= n || c>=m ) continue;

                    deque.addLast(new int[]{r,c});
                    break;

                }
            }


        }

    }
}
