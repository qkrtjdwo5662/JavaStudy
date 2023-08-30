import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_2210 {
    public static int[][] map;
    public static int length = 6;
    public static int count = 0;
    public static int[] rx = {0, 0, 1, -1};
    public static int[] ry = {1, -1, 0, 0};
    public static ArrayList<String> arrayList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(new int[]{i,j}, "");
            }
        }

        System.out.println(arrayList.size());

    }
    public static void dfs(int[] now, String s){
        if(s.length() == length) {
            if(!arrayList.contains(s)){
                arrayList.add(s);
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int r = now[0] + ry[i];
            int c = now[1] + rx[i];

            if(r <0 || c<0 || r>=5 || c>=5) continue;

            dfs(new int[]{r,c}, s+map[r][c]);
        }
    }
}
