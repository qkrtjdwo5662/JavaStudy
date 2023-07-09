import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class N_2667 {
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        boolean[][] visited = new boolean[n][n];
        ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1 && !visited[i][j]){
                    int count = 1;
                    visited[i][j] = true;
                    arrayDeque.addLast(new int[]{i, j});
                    while(!arrayDeque.isEmpty()){
                        int[] now = arrayDeque.pollFirst();
                        for (int k = 0; k < 4; k++) {
                            int r = now[0] + ry[k];
                            int c = now[1] + rx[k];

                            if(r<0 || c<0 || r>=n || c>=n) continue; // map 범위 밖

                            if(map[r][c] == 0) continue; // map 원소 0이면 건너뜀

                            if(!visited[r][c]){
                                visited[r][c] = true;
                                arrayDeque.addLast(new int[]{r,c});
                                count++;
                            }

                        }
                    }
                    if(count!=0){
                        arrayList.add(count);
                    }
                }
            }
        }
        Collections.sort(arrayList);

        if(arrayList.size() == 0){
            System.out.println(0);
            return;
        }
        sb.append(arrayList.size()).append("\n");

        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i)).append("\n");
        }
        System.out.print(sb);

    }
}
