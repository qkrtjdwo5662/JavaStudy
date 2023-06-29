import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class N_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> {
            int absX = Math.abs(x);
            int absY = Math.abs(y);

            if(absX==absY){ // 절댓 값 x, y 같을 때
                if(x<=y) return -1;
                else return 1;
            }
            else if(absX < absY) return -1;
            else return 1;

        });
        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(br.readLine());

            if(data == 0){ // 0이면 출력
                if(pq.isEmpty()){ // 비어있으면 0 출력
                    sb.append(0).append("\n");
                    continue;
                }
                sb.append(pq.poll()).append("\n");
            }else{
                pq.add(data); // 0이 아니면 넣고
            }
        }
        System.out.print(sb);

    }
}
