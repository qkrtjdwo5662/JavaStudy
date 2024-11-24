import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_20055 {
    static class Robot{
        int y;
        int x;
        boolean active;
        public Robot(int y, int x){
            this.y = y;
            this.x = x;
            this.active = true;
        }
    }
    static int n;
    static int k;
    static int[][] belt;
    static boolean[][] visited;
    static int[] ry = {0, 1, 0, -1};
    static int[] rx = {1, 0, -1, 0};
    static ArrayList<Robot> robotList;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken()); //
        k = Integer.parseInt(st.nextToken()); // 내구도 0인 칸 개수 k개 이상이면 종료
        belt = new int[2][n];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            belt[0][i] = num;
        }

        for (int i = n - 1; i >= 0; i--) {
            int num = Integer.parseInt(st.nextToken());
            belt[1][i] = num;
        }

        robotList = new ArrayList<>();


//        rotateBelt();
//        print();
        int count = 1;
        while(true){
            rotateBelt();

            moveRobots();
            if(belt[0][0] > 0){
                Robot robot = new Robot(0, 0);
                belt[0][0] -- ;
                robotList.add(robot);
            }


            if(!countZero()) break;
            count ++;
        }

        sb.append(count).append("\n");
        System.out.println(sb);
    }
    static boolean countZero(){
        int count = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                if(belt[i][j] < 1) count ++;
            }
        }

        if(count >= k) return false;
        return true;

    }
    static void rotateBelt(){
        visited = new boolean[2][n];
        move(0, belt[1][0], new int[]{0, 0});

        for (int i = 0; i < robotList.size(); i++) {
            Robot robot = robotList.get(i);

            if(!robot.active) continue;

            int r = robot.y;
            int c = robot.x;

            r += ry[0];
            c += rx[0];

            if(c == n){
                robot.active = false;
            }else robot.x = c;
        }
    }

    static void move(int depth, int prev, int[] now){
        if(depth == 2*n){
            return;
        }

        int temp = belt[now[0]][now[1]];
        belt[now[0]][now[1]] = prev;

        for (int i = 0; i < 4; i++) {
            int r = now[0] + ry[i];
            int c = now[1] + rx[i];

            if(r < 0 || c < 0 || r >= 2 || c >= n) continue;

            if(visited[r][c]) continue;

            visited[r][c] = true;
            move(depth + 1, temp, new int[]{r, c});
            break;
        }

    }

    static void moveRobots(){
        loop:
        for (int i = 0; i < robotList.size(); i++) {
            Robot robot = robotList.get(i);

            if(!robot.active) continue;

            int r = robot.y;
            int c = robot.x;

            r += ry[0];
            c += rx[0];

            if(c == n){
                robot.active = false;
                continue;
            }

            for (int j = i-1; j >= 0; j--) {
                Robot other = robotList.get(j);
                if(!other.active) continue;
                if(other.x == c) continue loop;
            }

            if(belt[r][c] < 1) continue;

            robot.x = c;
            belt[r][c] --;
        }
    }
}
