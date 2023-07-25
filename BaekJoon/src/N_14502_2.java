import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_14502_2 {
    public static int[] rx = {0,0, 1, -1};
    public static int[] ry = {1,-1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        ArrayList<int[]> blank = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int info = Integer.parseInt(st.nextToken());
                map[i][j] = info;

                if(info == 0) blank.add(new int[]{i,j}); // 바이러스 위치
            }
        }

        boolean[][] visited = new boolean[n][m];
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < blank.size()-2; i++) {
            for (int j = i+1; j < blank.size()-1; j++) {
                for (int k = j+1; k < blank.size(); k++) {
                    map[blank.get(i)[0]][blank.get(i)[1]] = 1;
                    map[blank.get(j)[0]][blank.get(j)[1]] = 1;
                    map[blank.get(k)[0]][blank.get(k)[1]] = 1;
                    // 빈칸 중 3개를 골라 벽 세우고

                    int count = 0;
                    for (int l = 0; l < n; l++) {
                        for (int o = 0; o < m; o++) {
                            if(map[l][o] == 2 && !visited[l][o]){ //바이러스면서, 방문하지 않은 지점
                                visited[l][o] = true;
                                deque.addLast(new int[]{l, o});

                                while(!deque.isEmpty()){
                                    int[] now = deque.pollFirst();

                                    for (int p = 0; p < 4; p++) {
                                        int r = now[0] + ry[p];
                                        int c = now[1] + rx[p];

                                        if(r<0 || c<0 || r>=n || c>=m) continue;

                                        if(map[r][c] == 1) continue;

                                        if(map[r][c]==0 && !visited[r][c]){
                                            visited[r][c] = true;
                                            deque.addLast(new int[]{r, c});
                                            map[r][c] = 2;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    for (int l = 0; l < n; l++) {
                        for (int o = 0; o < m; o++) {
                            if(map[l][o] == 0) count++; // 안전지대 영역 count
                        }
                    }

                    answer = Math.max(answer, count); // 가장 큰 count 값을 저장

                    //초기화 영역
                    for (int l = 0; l < n; l++) {
                        for (int o = 0; o < m; o++) {
                            visited[l][o] = false;
                        }
                    } // 방문 원상복귀
                    for (int l = 0; l < blank.size(); l++) {
                        int[] now = blank.get(l);
                        map[now[0]][now[1]] = 0;
                    }// 빈칸 원상복귀

                }
            }
        }


        System.out.println(answer);




    }
}
