import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class N_2750_heap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(br.readLine());
            pq.add(data);
        }

        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }
        System.out.print(sb);
    }
}
