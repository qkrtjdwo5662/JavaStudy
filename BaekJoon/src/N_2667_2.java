import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class N_2667_2 {
    public static int n;
    public static int[][] board;
    public static ArrayList<Integer> arrayList;
    public static boolean[][] visited;
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j <n ; j++) {
                int num = s.charAt(j) - '0';
                board[i][j] = num;
            }
        }
        int answer = 0;
        arrayList = new ArrayList<>();
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && board[i][j] == 1){
                    bfs(new int[]{i, j});
                    answer++;
                }
            }
        }

        sb.append(answer).append("\n");

        Collections.sort(arrayList);
        for (int i = 0; i <arrayList.size() ; i++) {
            sb.append(arrayList.get(i)).append("\n");
        }

        System.out.println(sb);

    }

    public static void bfs(int[] start){
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        visited[start[0]][start[1]] = true;

        deque.addLast(start);
        int count = 1;
        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r<0 || c<0 || r>= n || c>= n) continue;

                if(board[r][c] == 0) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[]{r,c});
                    count = count +1;
                }
            }
        }

        arrayList.add(count);
    }
}
