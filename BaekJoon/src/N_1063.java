import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1063 {
    public static int[] rx = {1,-1, 0, 0, 1, -1, 1, -1};
    public static int[] ry = {0, 0, -1, 1, 1, 1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] board = new int[8][8];

        String king = st.nextToken();
        String stone = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        int x_k = king.charAt(0) - 'A';
        int y_k = king.charAt(1) - '1';

        int x_s = stone.charAt(0) - 'A';
        int y_s = stone.charAt(1) - '1';

//        board[y_k][x_k] = 1; // king
//        board[y_s][x_s] = 2; // stone

        int[] now_k = new int[]{y_k, x_k};
        int[] now_s = new int[]{y_s, x_s};
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int d = -1;
            switch (op){
                case "R" : d=0;
                    break;
                case "L" : d=1;
                    break;
                case "B" : d=2;
                    break;
                case "T" : d=3;
                    break;
                case "RT" : d=4;
                    break;
                case "LT" : d=5;
                    break;
                case "RB" : d=6;
                    break;
                case "LB" : d=7;
                    break;
            }

            int rk = now_k[0] + ry[d];
            int ck = now_k[1] + rx[d];

            if(rk<0 || ck<0 || rk>=8 || ck>=8) continue;

            if(rk == now_s[0] && ck == now_s[1]){
                int rs = now_s[0] + ry[d];
                int cs = now_s[1] + rx[d];

                if(rs<0 || cs<0 || rs>=8 || cs>=8){
                    continue;
                }else{
                    now_s[0] = rs;
                    now_s[1] = cs;

                    now_k[0] = rk;
                    now_k[1] = ck;
                }
            }else{
                now_k[0] = rk;
                now_k[1] = ck;
            }
        }

        char a= (char) (king.charAt(0) + (now_k[1] - x_k));
        sb.append(a).append( now_k[0]+1).append("\n");

        char b = (char) (stone.charAt(0) + now_s[1] - x_s);
        sb.append(b).append(now_s[0] +1).append("\n");

        System.out.print(sb);
    }
}
