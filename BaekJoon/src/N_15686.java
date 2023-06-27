import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_15686 {
    public static ArrayList<int []> house;
    public static ArrayList<int []> chicken;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        house = new ArrayList<>(); // 집 좌표
        chicken = new ArrayList<>(); // 치킨 집 좌표

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int data = Integer.parseInt(st.nextToken());
                map[i][j] = data;
                if (data == 1) house.add(new int[]{i, j});
                else if (data == 2) chicken.add(new int[]{i, j});
            }
        }
        // 집, 치킨 집으로 분류

        // depth(m) 2일 떄
        int answer = Integer.MAX_VALUE;

//        for (int i = 0; i < chicken.size()-1; i++) {
//            for (int j = i+1; j < chicken.size(); j++) {
//                int sum = 0;
//                for (int k = 0; k < house.size(); k++) {
//                    sum = sum + Math.min(
//                            (Math.abs(chicken.get(i)[0] - house.get(k)[0]) + Math.abs(chicken.get(i)[1] - house.get(k)[1])),
//                            (Math.abs(chicken.get(j)[0] - house.get(k)[0]) + Math.abs(chicken.get(j)[1] - house.get(k)[1]))
//                    );
//                    //한 집으로 부터 두 개의 치킨 집까지 거리 들 중 작은 값
//                }
//                answer = Math.min(sum, answer);
//            }
//        }


        System.out.println(answer);
    }

    public static void backtrack(int depth, int m){
        if(depth == m)

            return;
    }
}
