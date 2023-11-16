import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_15903_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            long num = Integer.parseInt(st.nextToken());
            pq.add(num);
        }

        while(m>0){
            long firstNum = pq.poll();
            long secondNum = pq.poll();

            long sum = firstNum + secondNum;

            pq.add(sum);
            pq.add(sum);

            m -=1;
        }

        long answer = 0;

        while(!pq.isEmpty()){
            answer += pq.poll();
        }

        System.out.println(answer);
    }
}
