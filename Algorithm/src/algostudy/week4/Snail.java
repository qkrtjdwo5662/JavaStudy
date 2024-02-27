package algostudy.week4;


public class Snail {

    static int[][] board = new int[5][5];

    static int x = 0;
    static int y = 0;
    static int dir = 0;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static boolean inRange(int x, int y) {
        return ((0 <= x && x < 5) && (0 <= y && y < 5));
    }

    public static void outerSnail() {

        int num = 1;
        board[x][y] = num;

        while(true) {
            // 1. 종료 조건
            int check = 0;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(inRange(nx, ny) && board[nx][ny] != 0)
                    check++;
            }

            if(check == 4)
                break;

            // 2. 전진
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 3. 범위 바깥 or 칸에 막혔다면 => 방향 전환
            if(!inRange(nx, ny) || board[nx][ny] != 0) {
                dir = dir >= 3 ? 0 : (dir+1);
            }
            // 4. 실제 좌표 갱신 & 값 추가
            x = x + dx[dir];
            y = y + dy[dir];
            board[x][y] = ++num;
        }
    }

    public static void innerSnail() {

        board = new int[5][5];

        int direction = 2, moveCnt = 0, number = 1;
        board[x][y] = 1;

        int dist = 1;

        while(true) {
            moveCnt += 1;
            // STEP 1. dist 만큼 dir 방향으로 이동
            for(int i = 0; i < dist; i++) {
                int nx = x + dx[direction];
                int ny = y + dy[direction];

                // 종료 조건 : 범위 나가면 종료
                if(nx == 0 && ny == -1)
                    return;

                number += 1;
                board[nx][ny] = number;

                x = nx;
                y = ny;
            }

            // 같은 방향으로 2번 이동한 경우, 방향을 바꾼다.
            if(moveCnt == 2) {
                dist += 1;
                moveCnt = 0;
            }

            direction = direction <= 0 ? 3 : direction-1 ;
        }

    }

    public static void print() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++)
                sb.append(board[i][j]).append(" ");
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) {

        outerSnail();
        print();

        System.out.println();

        innerSnail();
        print();
    }
}

