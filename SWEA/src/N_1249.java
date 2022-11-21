import java.util.*;
public class N_1249 {

    static int N;
    static int min;
    static int [][] map;
    static boolean [][] isVisited;
    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        min = Integer.MAX_VALUE;
        map = new int[N][N];
        isVisited = new boolean[N][N];

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                map [i][j] = sc.nextInt();
            }
        }

        bfs(0,0);

        System.out.println();


    }
    static class Pos implements Comparable<Pos>
    {
        int x;
        int y;
        int time;
        Pos(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Pos o) {
            if(this.time >o.time)
                return 1;
            else if(this.time<o.time)
                return -1;
            return 0;
        }
    }
    static void bfs(int x, int y){
        PriorityQueue<Pos> que= new PriorityQueue<>();

        que.add(new Pos(x,y,0));
        isVisited[x][y] = true;

        while(!que.isEmpty())
        {
            Pos p = que.poll();

            int curX = p.x;
            int curY = p.y;
            int curT = p.time;

            if(curX == N-1 && curY ==N-1)
            {
                min = Math.min(min, curT);
            }
            for(int t=0; t<4; t++)
            {
                int nx = curX + dx[t];
                int ny = curY + dy[t];

                if(nx <0 || ny < 0 || nx >= N || ny >= N)
                    continue;
                if(!isVisited[nx][ny])
                {
                    int totalTime = curT + map[nx][ny]; // 탐색한 좌표에 있는 수(복구시간)을 더해 이 경로까지의 총 복구 시간을 구한다.
                    que.add(new Pos(nx, ny, totalTime)); // 그 시간과 새로운 좌표를 큐에 넣는다.
                    isVisited[nx][ny] = true;
                }
            }
        }


    }

}
