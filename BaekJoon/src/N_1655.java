import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class N_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> asc = new PriorityQueue<>();
        PriorityQueue<Integer> desc = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n ; i++) {
            int data = Integer.parseInt(br.readLine());
            if(asc.size() == desc.size()){
                desc.add(data);
            }else asc.add(data);

            if(!desc.isEmpty() && !asc.isEmpty()){
                if(desc.peek() > asc.peek()){
                    asc.add(desc.poll());
                    desc.add(asc.poll());
                }
            }


            sb.append(desc.peek()).append("\n");

        }
        System.out.println(sb);


    }
}
