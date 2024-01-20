import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_15686_3 {
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][n];
        ArrayList<int[]> chicken = new ArrayList<>();
        ArrayList<int[]> house = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;

                if(num == 1) house.add(new int[]{i, j});
                else if(num == 2) chicken.add(new int[]{i, j});

            }
        }

        // 치킨 집 중 최대 m개의 치킨집을 고른다.

        boolean[] visited = new boolean[chicken.size()];
        answer= Integer.MAX_VALUE;
        backtrack(chicken, house, new ArrayList<>(), visited, m, 0);

        System.out.println(answer);
        // 5
    }

    public static void backtrack(ArrayList<int[]> chicken, ArrayList<int[]> house, ArrayList<int[]> list, boolean[] visited , int m, int index){
        if(list.size() == m){
            answer=  Math.min(answer, minDist(house, list));
            return;
        }
        for (int i = index; i < chicken.size(); i++) {
            if(!visited[i]){
                visited[i] = true;
                list.add(chicken.get(i));
                backtrack(chicken, house, list, visited, m, i );
                list.remove(list.size() -1);
                visited[i] = false;
            }
        }
    }

    public static int minDist(ArrayList<int[]> house, ArrayList<int[]> chickenList){
        int total = 0;
        for (int i = 0; i < house.size(); i++) {
            int[] h = house.get(i);

            int minDist = Integer.MAX_VALUE;
            for (int j = 0; j < chickenList.size(); j++) {
                int[] c = chickenList.get(j);
                int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                minDist = Math.min(minDist, dist);
            }
            total += minDist;
        }
        return total;
    }

//    public static void printList(ArrayList<int[]> list){
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
//        }
//    }
}
