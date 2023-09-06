import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class DesertIsland_3 {
    public static String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};

    public static int n;
    public static int m;
    public static int[][] board;
    public static boolean[][] visited;
    public static ArrayList<Integer> arrayList;
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};
    public static void main(String[] args) {
        System.out.println(solution(maps));
    }

    public static int[] solution(String[] maps){
        //String 배열 -> int 2차원 배열

        n = maps.length;
        m = maps[0].length();

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = maps[i];
            for (int j = 0; j < m; j++) {
                if(s.charAt(j) == 'X'){
                    continue;
                }
                board[i][j] = s.charAt(j) - '0';
            }
        }

        visited = new boolean[n][m];
        arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] != 0 && !visited[i][j]){
                    bfs(new int[]{i,j});
                }
            }
        }

        if(arrayList.size() == 0) {
            return new int[]{-1};
        }
        Collections.sort(arrayList);

        int[] answer = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }
        return answer;
    }

    public static void bfs(int[] start){
        ArrayDeque<int[]> deque = new ArrayDeque<>();

        deque.addLast(start);
        visited[start[0]][start[1]] = true;
        int sum = board[start[0]][start[1]];

        while(!deque.isEmpty()){
            int[] now = deque.pollFirst();

            for (int i = 0; i < 4 ; i++) {
                int r = now[0] + ry[i];
                int c = now[1] + rx[i];

                if(r<0 || c<0 || r>=n || c>=m) continue;

                if(board[r][c] == 0) continue;

                if(!visited[r][c]){
                    visited[r][c] = true;
                    deque.addLast(new int[]{r,c});
                    sum = sum + board[r][c];
                }
            }
        }

        arrayList.add(sum);

    }
}
