import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_15686 {
    public static int m;
    public static ArrayList<int[]> chicken;
    public static ArrayList<int[]> homeList;
    public static boolean[] visited;
    public static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        homeList = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int data = Integer.parseInt(st.nextToken());
                map[i][j] = data;

                if(data == 1){
                    homeList.add(new int[]{i,j});
                } else if (data == 2) {
                    chicken.add(new int[]{i,j});
                }
            }
        }

        visited = new boolean[chicken.size()];

        backtrack(0, 0);
        System.out.println(answer);
    }
    public static void backtrack(int num, int count){
        if(count == m){ // 선택 개수 맥시멈 차면
            // 계산 시작

            answer = Math.min(answer, minDist());
            return;
        }

        for (int i = num; i < chicken.size(); i++) {
            if(!visited[i]){
                visited[i] = true;


                backtrack(i+1, count+1);

                visited[i] = false;
            }
        }
    }

    public static int minDist(){
        int result =0;
        for (int i = 0; i < homeList.size(); i++) {
            int[] now = homeList.get(i);
            int min = Integer.MAX_VALUE;
            int dist = 0;

            for (int j = 0; j < chicken.size(); j++) {
                if(visited[j]){
                    dist = Math.abs(now[0] - chicken.get(j)[0]) + Math.abs(now[1] - chicken.get(j)[1]);
                    min = Math.min(min, dist);
                }
            }
            result = result + min;

        }
        return result;
    }
}
