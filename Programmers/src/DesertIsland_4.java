import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DesertIsland_4 {
    public static String[] map = {"X591X","X1X5X","X231X", "1XXX1"};

    public static int n;
    public static int m;
    public static boolean[][] visited;
    public static int[][] board;
    public static ArrayList<Integer> arrayList;
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(map)));
    }

    public static int[] solution(String[] map){
        n = map.length;
        m = map[0].length();

        board = new int[n][m];


        for (int i = 0; i < n; i++) {
            String s = map[i];
            for (int j = 0; j < m; j++) {
                if(s.charAt(j) == 'X'){
                    board[i][j] = 0;
                }else{
                    board[i][j] = s.charAt(j) - '0';
                }
            }
        }

        visited = new boolean[n][m];
        arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] != 0 && !visited[i][j]) {
                    bfs(new int[]{i,j});
                }
            }
        }

        if(arrayList.size() == 0) return new int[]{-1};
        Collections.sort(arrayList);
        int[] answer = new int[arrayList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = arrayList.get(i);
        }
        return answer;
    }

    public static void bfs(int[] start){
        ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();

        visited[start[0]][start[1]] = true;
        arrayDeque.addLast(start);

        int sum = board[start[0]][start[1]];
        while(!arrayDeque.isEmpty()){
            int[] now = arrayDeque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r < 0 || c < 0 || r >= n || c>= m ) continue;

                if(board[r][c] == 0) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    arrayDeque.addLast(new int[]{r,c});
                    sum = sum + board[r][c];
                }
            }
        }
        arrayList.add(sum);
    }
}
