package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_14413 {
    public static int[] ry = {1, -1, 0, 0};
    public static int[] rx = {0, 0, 1, -1};

    public static int n;
    public static int m;
    public static int[][] board;
    public static int count;
    public static ArrayList<int[]> list;
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

            board = new int[n][m];
            list = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                String s = st.nextToken();

                for (int k = 0; k < s.length(); k++) {
                    if(s.charAt(k) == '#'){ // black 1
                        board[j][k] = 1;
                    }else if(s.charAt(k) == '.'){ // white 2
                        board[j][k] = 2;
                    }else{ // ? 0  -> queue
                        list.add(new int[]{j, k});
                    }
                }
            }

            count = list.size();

            answer = false;
            dfs(board, 0);

            if(answer){
                sb.append("#").append(i).append(" ").append("possible").append("\n");
            }else{
                sb.append("#").append(i).append(" ").append("impossible").append("\n");
            }



        }

        System.out.println(sb);

    }
    public static void dfs(int[][] board, int depth){
        if(answer) return;

        if(!checkBoard(board)) return;

        if(depth == count) {
            answer = true;
            System.out.println(Arrays.deepToString(board));
            return;
        }



        int[] now = list.get(depth);

        board[now[0]][now[1]] = 1;
        dfs(board, depth+1);


        board[now[0]][now[1]] = 2;
        dfs(board, depth+1);



    }

    public static boolean checkBoard(int[][] board){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 1 || board[i][j] == 2){
                    int color = board[i][j];

                    for (int k = 0; k< 4; k++) {
                        int r = i + ry[k];
                        int c = j + rx[k];


                        if(r < 0 || c< 0|| r>= n || c>= m) continue;

                        if(board[r][c] == color){
                            return false; // 인접 격자판 겹침
                        }
                    }

                }
            }
        }

        return true;
    }
}
