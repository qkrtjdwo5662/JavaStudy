import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;


public class N_409 {
    public static int[] ry = {1, -1, 0, 0};
    public static int[] rx = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        boolean[][] visited = new boolean[n][n]; // 방문체크
        ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && board[i][j] == 1){
                    int count = 1;
                    visited[i][j] = true;
                    arrayDeque.addLast(new int[]{i, j});

                    while(!arrayDeque.isEmpty()){

                        int[] now = arrayDeque.pollFirst();
                        for (int k = 0; k < 4; k++) {
                            int r = now[0] + ry[k];
                            int c = now[1] + rx[k];

                            if(r<0 || c<0 || r>=n || c>=n){ // 범위 벗어나면
                                continue;
                            }

                            if(board[r][c] == 0) continue;

                            if(!visited[r][c]){
                                visited[r][c] = true;
                                arrayDeque.addLast(new int[]{r, c});
                                count = count+1;
                            }
                        }
                    }
                    arrayList.add(count);
                }
            }
        }
        Collections.sort(arrayList);
        if(arrayList.size() == 0){
            System.out.println(0);
        }else{
            sb.append(arrayList.size()).append("\n");
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(arrayList.get(i)).append("\n");
            }
        }

        System.out.print(sb);
    }
}
