package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1824_fail {
    public static int n;
    public static int m;
    public static int[] ry = {0, 0, -1, 1};
    public static int[] rx = {-1, 1, 0, 0};
    public static char[][] board;
    public static boolean[][][][] visited;
    public static boolean answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            board = new char[n][m];
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for (int k = 0; k < m; k++) {
                    char c = s.charAt(k);
                    board[j][k] = c;
                    if(c == '@') flag = true;
                }
            }
            if(!flag) { // board에 @ 없으면 NO
                sb.append("#").append(i).append(" ").append("NO").append("\n");
                continue;
            }
            answer = false;
            visited = new boolean[n][m][16][4]; // y, x, memory, d
            int memory = 0;
            int d = 1;
            // 초기 메모리 0
            // 초기 방향 오른쪽
            dfs(new int[]{0, 0}, memory, d);
            if(answer){
                sb.append("#").append(i).append(" ").append("YES").append("\n");
            }else{
                sb.append("#").append(i).append(" ").append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void dfs(int[] now, int memory, int d){
        // now 좌표
        // memory 메모리
        // 방향
        if(answer) return;

        if(visited[now[0]][now[1]][memory][d]) {
            return;
        }
        visited[now[0]][now[1]][memory][d] = true;


        char opr = board[now[0]][now[1]];

        if(opr == '<' || opr == '>' || opr == '^' || opr == 'v'){
            if(opr == '<'){
                d = 0;
            }else if(opr == '>'){
                d = 1;
            }else if(opr == '^'){
                d = 2;
            }else if(opr == 'v'){
                d = 3;
            }
        }else if(opr == '_' || opr == '|'){ // memory보고 이동방향 바꿈
            if(opr == '_'){
                if(memory == 0){
                    d = 1;
                }else{
                    d = 0;
                }
            }else if(opr == '|'){
                if(memory == 0){
                    d = 3;
                }else{
                    d = 2;
                }
            }
        }else if(opr == '?'){ // random
            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r < 0 || c< 0 || r>=n || c>= m){
                    if(r < 0){
                        r = n-1;
                    }else if(r >= n){
                        r = 0;
                    }

                    if(c < 0){
                        c = m-1;
                    }else if(c >= m){
                        c = 0;
                    }
                }
                dfs(new int[]{r, c}, memory, d);
            }
            return;
        }else if(opr == '@'){ // stop
            answer = true;
            return;
        }else if(opr == '.'){// nothing

        }else if(opr - '0' >= 0 && opr - '0' <10){ // 0~9 memory 갱신
            memory = opr - '0';
        }else if(opr == '+' || opr == '-'){ // memory -- or memory ++
            if(opr == '+'){
                memory = memory + 1;
                if(memory == 16) memory = 0;
            }else{
                memory = memory -1;
                if(memory == -1
                ) memory = 15;
            }
        }


        int r = now[0] + ry[d];
        int c = now[1] + rx[d];

        if(r < 0 || c< 0 || r>=n || c>= m){
            if(r < 0){
                r = n-1;
            }else if(r >= n){
                r = 0;
            }

            if(c < 0){
                c = m-1;
            }else if(c >= m){
                c = 0;
            }
        }

        dfs(new int[]{r, c}, memory, d);


    }
}
