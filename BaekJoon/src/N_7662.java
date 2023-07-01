import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_7662 {
    public static PriorityQueue<Integer> pq;
    public static PriorityQueue<Integer> temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        temp = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < tc; i++) {
            st =  new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String operation = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if(operation.equals("I")){
                    pq.add(num);
                    temp.add(num);
                }else{
                    if(num == -1){
                        pq.poll();
                    }else{
                        pq.remove(temp.poll());
                    }
                }
            }
            if(pq.isEmpty()){
                sb.append("EMPTY").append("\n");
                continue;
            };
            sb.append(temp.poll()).append(" ").append(pq.poll()).append("\n");

            pq.clear();
            temp.clear();
        }
        System.out.print(sb);

    }
}
