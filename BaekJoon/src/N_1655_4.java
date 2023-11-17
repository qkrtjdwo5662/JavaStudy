import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class N_1655_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());


        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(i%2 == 0){
                maxHeap.add(num);
            }else{
                minHeap.add(num);
            }

           if(minHeap.isEmpty()){
               sb.append(maxHeap.peek()).append("\n");
           }else{
               if(maxHeap.peek() > minHeap.peek()){
                   int maxPoll = maxHeap.poll();
                   int minPoll = minHeap.poll();

                   minHeap.add(maxPoll);
                   maxHeap.add(minPoll);
               }

               sb.append(maxHeap.peek()).append("\n");
           }

        }
        System.out.println(sb);
    }
}
