import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class N_1715_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            pq.add(num);
        }

        int answer = 0;

        if(pq.size() < 2){

            System.out.println(0);
        }else{

            int sum = 0;
            while(pq.size() > 2){
                int first = pq.poll();
                int second = pq.poll();

                sum = first + second;
                answer = answer + sum;
                pq.add(sum);
            }

            while(!pq.isEmpty()){
                answer = answer + pq.poll();
            }

            System.out.println(answer);
        }





    }
}
