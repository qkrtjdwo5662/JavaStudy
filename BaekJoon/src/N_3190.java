import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N_3190 {
    public static int[] ry = {0, 1, 0, -1};
    public static int[] rx = {1, 0, -1, 0};

    public static int n;
    public static int[][] board;
    public static HashMap<Integer, String> hash;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        board = new int[n][n];

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            y = y-1;
            x = x-1;

            board[y][x] = 1; // 사과 놓기
        }
        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());

        hash = new HashMap<>();
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            String d = st.nextToken();
            hash.put(m, d);
        }
        int answer = run();
        sb.append(answer);
        System.out.println(sb);

    }

    public static int run(){
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        int[] now = new int[]{0, 0}; // 시작 0, 0
        int d = 0; // 첫 시작 방향 0
        int time = 0;

        deque.addLast(new int[]{0,0});

        while(true){
            int r = now[0] + ry[d];
            int c= now[1] + rx[d];
            time ++;

            if(r < 0 || r >= n || c < 0 || c >= n){
                break;
            }

            int size  = deque.size();

            for (int i = 0; i < size; i++) {
                int[] pos = deque.pollFirst();

                if(pos[0] == r && pos[1] == c){
                    return time;
                }

                deque.addLast(pos);
            }

            if(board[now[0]][now[1]] == 1){
                board[now[0]][now[1]] = 0;
                deque.addLast(new int[]{r, c});
            }else if(board[now[0]][now[1]] == 0){
                deque.addLast(new int[]{r, c});
                deque.pollFirst();
            }

            if(hash.containsKey(time)){
                String direction = hash.get(time);
                if(direction.equals("D")){
                    d = (d + 1)%4;
                }else if(direction.equals("L")){
                    if(d == 0) d = 3;
                    else d = d-1;
                }
            }
            now[0] = r;
            now[1] = c;
        }

        return time;
    }
}
