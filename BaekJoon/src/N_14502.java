import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_14502 {
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        ArrayList<int[]> blank = new ArrayList<>(); // 0
        ArrayList<int[]> virus = new ArrayList<>(); // 2

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num == 0) blank.add(new int[]{i, j});
                if(num == 2) virus.add(new int[]{i, j});
            }
        }

        int answer = 0;


        for (int i = 0; i < blank.size()-2; i++) {
            for (int j = i+1; j < blank.size()-1; j++) {
                for (int k = j+1; k < blank.size(); k++) {
                    int[] first = blank.get(i);
                    int[] second = blank.get(j);
                    int[] third = blank.get(k);

                    map[first[0]][first[1]] = 1;
                    map[second[0]][second[1]] = 1;
                    map[third[0]][third[1]] = 1;
                    // 벽 세우기

                    boolean[][] visited = new boolean[n][m];
                    ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();

                    for (int l = 0; l < virus.size(); l++) {
                        visited[virus.get(l)[0]][virus.get(l)[1]] = true;
                        arrayDeque.addLast(new int[]{virus.get(l)[0],virus.get(l)[1]});
                    } // virus bfs

                    while(!arrayDeque.isEmpty()){
                        int[] now = arrayDeque.pollFirst();
                        for (int o = 0; o < 4; o++) {
                            int r = now[0] + ry[o];
                            int c = now[1] + rx[o];

                            if(r<0 || c<0 || r>=n || c>=m) continue;

                            if(map[r][c] == 1) continue;

                            if(!visited[r][c]){
                                visited[r][c] = true;
                                arrayDeque.add(new int[]{r, c});
                                map[r][c] = 2;
                            }
                        }
                    }
                    int count = 0;
                    for (int l = 0; l < n; l++) {
                        for (int o = 0; o < m; o++) {
                            if(map[l][o] == 0) count++;
                        }
                    }
                    answer = Math.max(answer, count);

                    // 계산 끝나면 원 위치
                    map[first[0]][first[1]] = 0;
                    map[second[0]][second[1]] = 0;
                    map[third[0]][third[1]] = 0;

                    for (int l = 0; l < blank.size(); l++) {
                        map[blank.get(l)[0]][blank.get(l)[1]] = 0;
                    }

                }
            }
        }
        System.out.println(answer);

    }
}
