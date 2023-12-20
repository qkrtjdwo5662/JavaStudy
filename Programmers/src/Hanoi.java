import java.util.ArrayList;
import java.util.Arrays;

public class Hanoi {
    public static int n = 3;
    public static ArrayList<int[]> list;
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(n)));
    }

    public static int[][] solution(int n){
        list = new ArrayList<>();
        hanoi(n, 1, 3, 2);
        int[][] answer = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }
        return answer ;
    }

    public static void hanoi(int n, int start, int to, int mid){
        if(n == 1){
            list.add(new int[]{start, to});
            return;
        }
        hanoi(n-1, start, mid, to); // 1 -> 2  mid: 3
        list.add(new int[]{start, to});
        hanoi(n-1, mid, to, start); // 2 -> 3  mid: 1
    }
}
