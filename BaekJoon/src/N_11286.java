import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class N_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            if(k == 0){ // k가 0일 때 (poll 얀신)
                if(pq.isEmpty()){ // pq empty check
                    sb.append(0).append("\n"); // 0
                }else {
                    int temp = pq.poll();
                    if(!pq.isEmpty() && Math.abs(temp)>pq.peek()){
                        sb.append(pq.poll()).append("\n");
                        pq.add(temp);
                    }else{
                        sb.append(temp).append("\n");
                    }
                }
            }else{ // k가 0이 아닐 때
                pq.add(k);
            }
        }
        System.out.print(sb);

    }
}
