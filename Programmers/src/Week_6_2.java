import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Week_6_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(br.readLine());

            if(i%2 == 0){
                maxHeap.add(data);
            }else{
                minHeap.add(data);
            }

            if(!maxHeap.isEmpty() && !minHeap.isEmpty()){
                if(maxHeap.peek() > minHeap.peek()){
                    int maxPoll = maxHeap.poll();
                    int minPoll = minHeap.poll();

                    maxHeap.add(minPoll);
                    minHeap.add(maxPoll);
                }
            }

            sb.append(maxHeap.peek()).append("\n");

        }
        System.out.println(sb);
    }
}
