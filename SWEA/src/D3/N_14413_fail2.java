package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_14413_fail2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] board = new int[n][m];

            ArrayList<int[]> black = new ArrayList<>();
            ArrayList<int[]> white = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();

                for (int k = 0; k < m; k++) {
                    if(s.charAt(k) == '#') {
                        board[j][k] = 1;
                        black.add(new int[]{j,k});
                    }
                    else if(s.charAt(k) == '.') {
                        board[j][k] = 2;
                        white.add(new int[]{j,j});
                    }
                }
            }
            if(check(black) && check(white)){
                sb.append("#").append(i).append(" ").append("possible").append("\n");
            }else{
                sb.append("#").append(i).append(" ").append("impossible").append("\n");
            }

        }
        System.out.println(sb);
    }
    public static boolean check(ArrayList<int[]> list){
        if(list.size() == 0) return true;

        int answer = (list.get(0)[0] + list.get(0)[1]) %2;

        for (int i = 0; i < list.size(); i++) {
            int[] now = list.get(i);

            if(answer != (now[0] + now[1]) % 2) return false;
        }

        return true;
    }
}
