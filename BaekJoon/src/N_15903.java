import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());

        int count = 0;
        long sum = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long data = Integer.parseInt(st.nextToken());
            pq.add(data);
        }

        while(count<m){
            long pollFirst = pq.poll();
            long pollSecond = pq.poll();
            long mix = pollFirst + pollSecond;

            pq.add(mix);
            pq.add(mix);

            count ++;
        }

        while(!pq.isEmpty()){
            sum = sum + pq.poll();
        }
        System.out.println(sum);



    }
}
