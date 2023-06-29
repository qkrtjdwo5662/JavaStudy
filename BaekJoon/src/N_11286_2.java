import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class N_11286_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> {
            // 절댓값
            int absX = Math.abs(x);
            int absY = Math.abs(y);

            if(absX == absY){ // 두 수의 절댓값이 같으면
                if(x<=y) return -1; // 원래 수를 비교하여 우선순위 부여
                else return 1;
            }
            else if (absX<absY) return -1; // -1 -3
            else return 1; // -3 -1
        });

        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(br.readLine());
            if(data == 0){ // 0 이면 출력
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                    continue;
                }
                int poll = pq.poll();
                sb.append(poll).append("\n");
            }else{
                pq.add(data);
            }
        }
        System.out.print(sb);


    }
}
