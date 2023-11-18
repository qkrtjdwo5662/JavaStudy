package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_1873 {
    public static int h;
    public static int w;
    public static int[] ry = {-1, 1, 0, 0};
    public static int[] rx = {0, 0, -1, 1};
    public static char[][] board;
    public static int direction;
    public static int[] now;
    public static char[] tank = {'^','v', '<', '>',};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            board = new char[h][w];

            direction = 0; // 방향

            now = new int[]{-1, -1};
            for (int j = 0; j < h; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for (int k = 0; k < w; k++) {
                    char c = s.charAt(k);
                    if(c == '<' || c=='>' || c=='^' || c=='v'){
                        if(c == '^'){
                            direction = 0;
                        }else if(c=='v'){
                            direction = 1;
                        }else if(c=='<'){
                            direction = 2;
                        }else {
                            direction = 3;
                        }
                        now[0] = j;
                        now[1] = k;
                    }

                    board[j][k] = c;
                }
            }
//            System.out.println(Arrays.toString(now));
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            String opr = st.nextToken();


            for (int j = 0; j < opr.length(); j++) {
                if(opr.charAt(j) == 'U'){ // 0
                    direction = 0;
                    move(direction);
                }else if(opr.charAt(j) == 'D'){ // 1
                    direction = 1;
                    move(direction);
                }else if(opr.charAt(j) == 'L'){ // 2
                    direction = 2;
                    move(direction);
                }else if(opr.charAt(j) == 'R'){ // 3
                    direction = 3;
                    move(direction);
                }else if(opr.charAt(j) == 'S'){
                    shoot(now);
                }
//                System.out.print(opr.charAt(j) + " ");
//                System.out.println(Arrays.toString(now));
//                System.out.println(direction);
//                System.out.println(Arrays.deepToString(board));
            }


            sb.append("#").append(i).append(" ");

            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    sb.append(board[j][k]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
    public static void shoot(int[] now){
        int r = now[0] + ry[direction];
        int c = now[1] + rx[direction];
        while(true){
            if(r < 0 || c< 0 || r>= h || c>= w) break;

            if(board[r][c] == '*' || board[r][c] == '#') { // 벽이라면
                if(board[r][c] == '*'){
                    board[r][c] = '.';
                }
                break;
            }else { // 평지라면 이동
                r = r + ry[direction];
                c = c + rx[direction];
            }
        }
    }
    public static void move(int direction){
        int r = now[0] + ry[direction];
        int c = now[1] + rx[direction];
        board[now[0]][now[1]] = tank[direction];

        if(r < 0 || c< 0 || r>= h || c>= w) return; // 밤위 벗어남

        if(board[r][c] == '.') { // 평지라면
            board[now[0]][now[1]] = '.';
            board[r][c] = tank[direction];
            now[0] = r;
            now[1] = c;
        }

    }
}
