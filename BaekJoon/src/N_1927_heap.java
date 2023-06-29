import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class N_1927_heap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(br.readLine());
            if(data == 0){  // 0이면 가장 작은 수 출력
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                    continue;
                }
                int poll = pq.poll();
                sb.append(poll).append("\n");
            }else { // 0이 아니라면
                pq.add(data);
            }
        }
        System.out.print(sb);
    }
}
