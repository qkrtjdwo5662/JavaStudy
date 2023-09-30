import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class N_1655_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());


        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 가장 작은 값 return
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 가장 큰 값 return

        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(br.readLine());
            if(minHeap.size() == maxHeap.size()){
                maxHeap.add(data);
            }else minHeap.add(data);


            if(!minHeap.isEmpty() && !maxHeap.isEmpty()){
                if(maxHeap.peek() > minHeap.peek()){
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(minHeap.poll());
                }
            }

            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
