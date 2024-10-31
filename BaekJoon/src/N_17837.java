import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_17837 {
    static int[] ry = {0, 0, -1, 1};
    static int[] rx = {1, -1, 0, 0};
    static int n;
    static int[][] board;
    static int[][] horse;
    static ArrayList<Integer>[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken()); // 체스판 크기
        int k = Integer.parseInt(st.nextToken()); // 말의 개수

        board = new int[n+1][n+1];
        map = new ArrayList[n+1][n+1];
        horse = new int[k][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                map[i][j] = new ArrayList<>();
            }
        }
        // 보드판 정보
        // 0 : 흰, 1 : 빨, 2: 파

        // 이동하려는 칸이 흰색인 경우
        // 해당 칸으로 그대로 이동
        // D, E // A, B, C(이동)
        // => D, E, A, B, C (위로 쌓이는 형태)


        // 이동하려는 칸이 빨간색인 경우
        // 이동 후 말의 쌓여있는 순서 반대로 바꿈
        //ex)1 A, B, C (이동)
        // => C, B, A (순서 바뀜)
        //ex)2 A, D, F, G // E, C, B (이동)
        // => E, C, B, G, F, D, A

        // 이동하려는 칸이 파란색인 경우, 혹은 맵을 벗어나는 경우
        // 이동방향을 반대로 하고 한칸이동
        // 방향을 바꾼 후에도 파란색인 경우 이동 X
        // 턴 진행시 말이 4개 이상 쌓이는 순간 게임 종료

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            horse[i][0] = y;
            horse[i][1] = x;
            horse[i][2] = d;
            map[y][x].add(i);
        }

        int turn = 0;

        while(turn <= 1000){
            turn++;
            for (int i = 0; i < k; i++) {
                int y = horse[i][0];
                int x = horse[i][1];
                int d = horse[i][2];
                int num = search(y, x, i);

                int r = y + ry[d];
                int c = x + rx[d];

                if(!isRange(r, c) || board[r][c] == 2){
                    // 파란색

                }else{
                    // 흰, 빨
                    if(board[r][c] == 0){
                        while(map[r][c].size() > num){

                        }
                    }else if(board[r][c] == 1){

                    }

                }
            }
        }
        sb.append("-1").append("\n");
        System.out.println(sb);

    }
    static int search(int y, int x, int n){
        for (int i = 0; i < map[y][x].size(); i++) {
            if(map[y][x].get(i) == n){
                return i;
            }
        }

        return -1;
    }
    static boolean isRange(int y, int x){
        if(y <= 0  || x <= 0  || y > n || x > n) return false;

        return true;
    }
}
