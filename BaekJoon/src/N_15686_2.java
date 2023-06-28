import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_15686_2 {
    public static int n;
    public static int m;
    public static ArrayList<int[]> chicken;
    public static ArrayList<int[]> home;
    public static boolean[] visited;
    public static int size;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];

        chicken = new ArrayList<>();
        home = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int data = Integer.parseInt(st.nextToken());
                map[i][j] = data;
                if(data == 1) home.add(new int[]{i,j});
                else if(data == 2) chicken.add(new int[]{i,j});
            }
        }
        size = chicken.size();
        visited = new boolean[size];
        answer = Integer.MAX_VALUE;
        backtrack( "", -1);
        System.out.println(answer);
    }
    public static void backtrack(String s, int num){
        if(s.length()== m){
            int sum =0;
            for (int i = 0; i < home.size(); i++) {
                int distance = Integer.MAX_VALUE;
                for (int j = 0; j < m; j++) {
                    int index = Integer.parseInt(String.valueOf(s.charAt(j)));
                    int d = Math.abs(chicken.get(index)[0] - home.get(i)[0]) + Math.abs(chicken.get(index)[1] - home.get(i)[1]);
                    distance = Math.min(distance, d);
                }
                sum = sum + distance;

            }
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = num+1; i < chicken.size(); i++) {
            if(!visited[i]){
                visited[i] = true;
                backtrack(s+i, i);
                visited[i] = false;
            }
        }
    }


}
