import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class N_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(br.readLine());
            pq.add(data);
        }
        if(n == 1){ // 2보다 작으면 꺼내서 return
            System.out.println(0);
            return;
        }

        while(pq.size() != 2 ){ // size가 2가 아니면 즉, 2보다 크면
            int answer =0;
            int peekFirst = pq.poll();
            int peekSecond = pq.poll();

            answer = peekFirst + peekSecond;
            pq.add(answer);
            sum = sum + answer;
        }

        // pq size가 2면 while문 벗어나서
        int answer =0;
        int peekFirst = pq.poll();
        int peekSecond = pq.poll();
        answer = peekFirst + peekSecond;
        sum = sum + answer;
        System.out.println(sum);

    }
}
