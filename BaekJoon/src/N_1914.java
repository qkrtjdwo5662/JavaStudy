import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1914 {
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        sb.append((int)Math.pow(2, n) - 1).append("\n");
        hanoi(n, 1,2, 3);
        System.out.print(sb);
    }

    public static void hanoi(int n, int start, int mid, int end){
        if(n == 1){
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }

        hanoi(n-1, start, end, mid);

        sb.append(start).append(" ").append(end).append("\n");

        hanoi(n-1, mid, start, end);
    }
}
