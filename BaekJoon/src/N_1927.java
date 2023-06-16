import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class N_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            if(k==0){ // 0 일때
                if(pq.isEmpty()){ // 0이면서 비었으면
                    sb.append(0).append("\n");
                }else{ //0이면서 비어있지 않으면
                    sb.append(pq.poll()).append("\n");
                }
            }else{ // 0 아니면
                pq.add(k);
            }
        }

        System.out.print(sb);
    }
}
