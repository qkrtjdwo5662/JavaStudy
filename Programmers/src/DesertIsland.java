import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class DesertIsland {
    public static String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
    public static int[] rx = {0,0, 1, -1};
    public static int[] ry = {1,-1, 0, 0};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(maps)));
    }

    public static int[] solution(String[] maps){

        int n = maps.length;
        int m = maps[0].length();

        int[][] intMap = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = maps[i];

            for (int j = 0; j < m; j++) {
                if(s.charAt(j) =='X') continue;
                else intMap[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && intMap[i][j] != 0){
                    visited[i][j] = true;
                    arrayDeque.addLast(new int[]{i,j});
                    int sum = 0;

                    while(!arrayDeque.isEmpty()){
                        int[] now = arrayDeque.pollFirst();
                        sum = sum + intMap[now[0]][now[1]];

                        for (int k = 0; k < 4; k++) {
                            int r = now[0] + ry[k];
                            int c = now[1] + rx[k];

                            if(r <0 || c<0 || r>=n || c >= m) continue;

                            if(intMap[r][c] ==0 ) continue;

                            if(!visited[r][c]){
                                visited[r][c] = true;
                                arrayDeque.addLast(new int[]{r,c});
                            }
                        }
                    }
                    arrayList.add(sum);
                }
            }
        }

        if(arrayList.size() == 0) return new int[]{ -1 };

        int[] answer = new int[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }

        Arrays.sort(answer);
        return answer;
    }
}
