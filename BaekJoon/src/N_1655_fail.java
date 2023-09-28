import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class N_1655_fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            int data = Integer.parseInt(br.readLine());
            pq.add(data); // 하나씩 입력 받아서 넣고
            PriorityQueue<Integer> temp = new PriorityQueue<>(); // 복사할 pq

            temp.addAll(pq); //

            if(i%2 == 0){ // 짝수 번 째 입력 (현재 까지 우산순위의 중간 두 수(size/2, size/2-1)중 작은 값 출력)
                for (int j = 0; j < i/2-1; j++) { // 0 1 2 3 4 5 i=6 6/2=3 3-1=2 1까지
                    temp.poll();
                }
                int midFirst = temp.poll();
                int midSecond = temp.poll();
                sb.append(Math.min(midFirst, midSecond)).append("\n");
            }else{ // 홀수 번 째 입력 (현재 까지 우선순위 큐의 중간 수 출력)
                for (int j = 0; j < i/2; j++) { // 0 1 2 3 4  i=5 5/2 = 2, 1까지
                    temp.poll();
                }
                int mid = temp.poll();
                sb.append(mid).append("\n");
            }
        }
        System.out.print(sb);
    }
}
