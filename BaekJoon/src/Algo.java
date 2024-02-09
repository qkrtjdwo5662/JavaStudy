import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo {
    static int n;
    static int m;
    static int k;
    static int c;
    static int[][] board;
    static int answer;
    static int[] rx = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] ry = {0, 1, 0, -1, -1, 1, -1, 1};
    static ArrayList<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken()); // 격자 크기 board n*n
        m = Integer.parseInt(st.nextToken()); // 진행 년수
        k = Integer.parseInt(st.nextToken()); // 제초 확산 범위 -> 대각선
        c = Integer.parseInt(st.nextToken()); // 제초제 남은 년수 // c년 후 제초제 영향 종료

        // 1년간의 과정
            // 1. 나무의 성장 -> 인접한 나무의 개수 파악 후 성장

            // 2. 나무의 번식
                // 나무와 인접한 4개의 칸 중 벽, 나무, 제초제 없는 곳에 번식 진행
                // ex) 6개의 나무 자란 칸 3개인접 -> 인접칸 2개씩 나무 생성
            // 3. 가장 나무 많이 박멸되는 곳 찾아서 제초제 투하
                // 3.1 제초제 투하 대각선 방향 k만큼 -> -2로 표기
                // 3.2 제초제 c년간 유지 -> 제초제를 뿌리는 순서는 행작, 열작 순

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }
        int day = 0;
        int count = 0;
        answer = 0;
        while(day < m){
            grow();
            System.out.println(Arrays.deepToString(board));

            breeding();
            System.out.println(Arrays.deepToString(board));

            compareKill();
            System.out.println(Arrays.deepToString(board));

            day ++;
            count++;

            if(count == c){
                clear();
                System.out.println(Arrays.deepToString(board));
                count = 0;
            }
        }

        sb.append(answer).append("\n");
        System.out.println(sb);


    }

    static void grow(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] > 0){
                    int count = 0;
                    for (int l = 0; l < 4; l++) {
                        int r = i + ry[l];
                        int c = j + rx[l];

                        if(r < 0 || c<0 || r>= n || c>= n ) continue;

                        if(board[r][c] > 0 ) count ++;
                    }

                    board[i][j] += count; // 성장
                }
            }
        }
    }

    static void breeding(){
        int[][] map = new int[n][n]; // 기록용

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] > 0){
                    ArrayList<int[]> list = new ArrayList<>();
                    for (int l = 0; l < 4; l++) {
                        int r = i + ry[l];
                        int c = j + rx[l];

                        if(r<0 || c<0 || r>= n || c>= n) continue;

                        if(board[r][c] != 0) continue;
                        list.add(new int[]{r, c});
                    }

                    if(list.size() != 0) {
                        int aver = board[i][j] / list.size();

                        for (int k = 0; k < list.size(); k++) {
                            int[] now = list.get(k);

                            map[now[0]][now[1]] += aver;
                        }
                    }
                }
            }
        }

        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 0){
                    board[i][j] = map[i][j];

                }
            }
        }
    }
    static void compareKill(){ // 완탐, 대각선 비교
        int[][] map = new int[n][n];
        int[] maxPosition = null;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 대각선 4방탐색
                if(board[i][j] > 0){
                    int sum = board[i][j];
                    for (int l = 4; l < 8 ; l++) {
                        int ny = i;
                        int nx = j;

                        for (int o = 0; o < k; o++) {
                            ny = ny + ry[l];
                            nx = nx + rx[l];

                            if(ny < 0 || nx < 0 || ny>= n || nx>= n) continue;

                            if(board[ny][nx] == -1 || board[ny][nx] == -2) break;

                            if(board[ny][nx] > 0){
                                sum += board[ny][nx];
                            }
                        }
                    }
                    map[i][j] = sum;
                    max = Math.max(max, sum);
                }
            }
        }

        loop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == max){
                    maxPosition = new int[]{i, j};
                    break loop;
                }
            }
        }

        answer+= max;
//        System.out.println(Arrays.toString(maxPosition));
        kill(maxPosition[0], maxPosition[1]);
    }
    static void kill(int y, int x){
        list = new ArrayList<>();
        list.add(new int[]{y, x});
        board[y][x] = -2;
        for (int i = 4; i <8 ; i++) {
            int ny = y;
            int nx = x;
            for (int j = 0; j < k; j++) {
                ny = ny + ry[i];
                nx = nx + rx[i];

                if(ny < 0 || nx < 0 || ny>= n || nx>= n) continue;

                if(board[ny][nx] == -1 || board[ny][nx] == -2) break;

//                if(board[ny][nx] > 0){
//                    board[ny][nx] = -2;
//                    System.out.println(ny + " " + nx);
//                    list.add(new int[]{ny, nx});
//                }
                board[ny][nx] = -2;
//                System.out.println(ny + " " + nx);
                list.add(new int[]{ny, nx});

            }
        }
//        System.out.println(list.size());
    }

    static void clear(){
        for (int i = 0; i < list.size(); i++) {
            int[] now = list.get(i);
            board[now[0]][now[1]] = 0;
        }
    }
}
