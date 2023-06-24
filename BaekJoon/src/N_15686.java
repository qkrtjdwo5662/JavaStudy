import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_15686 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        ArrayList<int []> house = new ArrayList<>();
        ArrayList<int []> chicken = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int data = Integer.parseInt(st.nextToken());
                map[i][j] = data;
                if (data == 1) house.add(new int[]{i, j});
                else if (data == 2) chicken.add(new int[]{i, j});
            }
        }
//        System.out.println(Arrays.deepToString(bfs(m, chicken)));

    }
    public static int[][] bfs(int m, ArrayList<int []> chicken){
        int[][] answer = new int[m][2];
        boolean[] visit = new boolean[chicken.size()];


        return answer;
    }
}
