import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_531 {
    public static int k;
    public static int answer = 4 * 1_000_000;
    public static ArrayList<int[]>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[k+1];
        for (int i = 1; i <= k; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());

            adjList[color].add(new int[]{x,y});
        }

        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        backtrack(0, 1,k, minX, maxX, minY, maxY);
        System.out.println(answer);
    }

    public static void backtrack(int count, int color, int depth, int minX, int maxX, int minY, int maxY){
        Math.abs((maxX-minX) * (maxY-minY));
        if(count == depth){
            // 영역 크기 구하기
            int size = Math.abs((maxX-minX) * (maxY-minY));

            answer = Math.min(answer, size);
            return;
        }


        boolean[] visited = new boolean[101];
        for (int i = 0; i < adjList[color].size(); i++) {
            if(!visited[i]){
                visited[i] = true;
                int x = adjList[color].get(i)[0];
                int y = adjList[color].get(i)[1];

                int minx = Math.min(minX, x);
                int maxx = Math.max(maxX, x);
                int miny = Math.min(minY, y);
                int maxy = Math.max(maxY, y);

                backtrack(count+1, color+1, depth, minx, maxx, miny, maxy);
                visited[i] = false;
            }
        }
    }
}
