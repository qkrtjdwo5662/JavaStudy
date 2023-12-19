import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_4396 {
    public static int n;
    public static char[][] board;
    public static char[][] map;
    public static int[] ry = {1, -1, 0, 0, 1, -1, -1, 1};
    public static int[] rx = {0, 0, 1, -1, 1, 1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        board = new char[n][n];
        ArrayList<int[]> mineList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                board[i][j] = c;
                if(c == '*') mineList.add(new int[]{i, j});
            }
        }
        map = new char[n][n];
        boolean stepMine = false;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                if(c == 'x'){
                    if(board[i][j] == '*'){
                        if(!stepMine){
                            stepMine = true;
                        }
                    }else{
                        checkMine(new int[]{i, j});
                    }
                }else{
                    map[i][j] = c;
                }
            }
        }
        if(stepMine) runMine(mineList);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void checkMine(int[] now){
        int count = 0;

        for (int i = 0; i < 8; i++) {
            int r = now[0] + ry[i];
            int c = now[1] + rx[i];

            if(r < 0|| c< 0 || r>= n || c>= n) continue;

            if(board[r][c] == '*') count++;
        }

        map[now[0]][now[1]] = (char) (count+'0');
    }

    public static void runMine(ArrayList<int[]> mineList){
        for (int[] mine : mineList) {
            map[mine[0]][mine[1]] = '*';
        }
    }
}
