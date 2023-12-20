import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_11729 {
    public static ArrayList<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        hanoi(n, 1, 3, 2);
        sb.append(list.size()).append("\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)[0]).append(" ").append(list.get(i)[1]).append("\n");
        }
        System.out.println(sb);

    }
    public static void hanoi(int n, int start, int target, int mid){
        if(n == 1){
            list.add(new int[]{start, target});
            return;
        }

        hanoi(n-1, start, mid, target); // 1 -> 2  3
        list.add(new int[]{start, target}); // n  1 -> 3
        hanoi(n-1, mid, target, start); // 2 -> 3  1

    }
}
