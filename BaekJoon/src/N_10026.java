import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class N_10026 {
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[n][n];

        for (int i = 0; i < n; i++) {
            String sentence = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = sentence.charAt(j);
                map[i][j] = c;
            }
        }

        boolean[][] visited = new boolean[n][n];
        ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && map[i][j] == 'R'){
                    arrayDeque.addLast(new int[]{i,j});
                    count++;
                    while(!arrayDeque.isEmpty()){
                        int[] now = arrayDeque.pollFirst();
                        for (int k = 0; k < 4; k++) {
                            int r = now[0] + ry[k];
                            int c = now[1] + rx[k];

                            if(r<0 || c<0 || r>=n || c>=n) continue;

                            if(map[r][c] != 'R') continue;

                            if(!visited[r][c]){
                                visited[r][c] = true;
                                arrayDeque.addLast(new int[]{r,c});
                            }
                        }
                    }
                }
                if(!visited[i][j] && map[i][j] == 'B'){
                    arrayDeque.addLast(new int[]{i,j});
                    count++;
                    while(!arrayDeque.isEmpty()){
                        int[] now = arrayDeque.pollFirst();
                        for (int k = 0; k < 4; k++) {
                            int r = now[0] + ry[k];
                            int c = now[1] + rx[k];

                            if(r<0 || c<0 || r>=n || c>=n) continue;

                            if(map[r][c] != 'B') continue;

                            if(!visited[r][c]){
                                visited[r][c] = true;
                                arrayDeque.addLast(new int[]{r,c});
                            }
                        }
                    }
                }
                if(!visited[i][j] && map[i][j] == 'G'){
                    arrayDeque.addLast(new int[]{i,j});
                    count++;
                    while(!arrayDeque.isEmpty()){
                        int[] now = arrayDeque.pollFirst();
                        for (int k = 0; k < 4; k++) {
                            int r = now[0] + ry[k];
                            int c = now[1] + rx[k];

                            if(r<0 || c<0 || r>=n || c>=n) continue;

                            if(map[r][c] != 'G') continue;

                            if(!visited[r][c]){
                                visited[r][c] = true;
                                arrayDeque.addLast(new int[]{r,c});
                            }
                        }
                    }
                }
            }
        }
        sb.append(count).append(" ");

        visited = new boolean[n][n];
        arrayDeque = new ArrayDeque<>();
        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && (map[i][j] == 'R' || map[i][j] == 'G')){
                    arrayDeque.addLast(new int[]{i,j});
                    count++;
                    while(!arrayDeque.isEmpty()){
                        int[] now = arrayDeque.pollFirst();
                        for (int k = 0; k < 4; k++) {
                            int r = now[0] + ry[k];
                            int c = now[1] + rx[k];

                            if(r<0 || c<0 || r>=n || c>=n) continue;

                            if(map[r][c] != 'R' && map[r][c] != 'G') continue;

                            if(!visited[r][c]){
                                visited[r][c] = true;
                                arrayDeque.addLast(new int[]{r,c});
                            }
                        }
                    }
                }
                if(!visited[i][j] && map[i][j] == 'B'){
                    arrayDeque.addLast(new int[]{i,j});
                    count++;
                    while(!arrayDeque.isEmpty()){
                        int[] now = arrayDeque.pollFirst();
                        for (int k = 0; k < 4; k++) {
                            int r = now[0] + ry[k];
                            int c = now[1] + rx[k];

                            if(r<0 || c<0 || r>=n || c>=n) continue;

                            if(map[r][c] != 'B') continue;

                            if(!visited[r][c]){
                                visited[r][c] = true;
                                arrayDeque.addLast(new int[]{r,c});
                            }
                        }
                    }
                }

            }
        }
        sb.append(count);
        System.out.print(sb);


    }
}
