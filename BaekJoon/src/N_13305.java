import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] distance = new int[n-1];
        int[] price = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n-1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n-1; i++) {
            pq.add(price[i]);
        }

        int answer = 0;
        int poll = pq.poll();

        int index =0;
        for (int i = 0; i < n-1; i++) {
            int amount = 0;
            if(price[i] != poll){
                amount = price[i] * distance[i];
            }else{
                index = i;
                break;
            }
            answer = answer + amount;
        }

        while(index < n-1){
            int amount = poll * distance[index];
            answer = answer + amount;
            index ++;
        }

        System.out.println(answer);
    }
}
