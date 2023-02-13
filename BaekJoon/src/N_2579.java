import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class N_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        PriorityQueue<Integer>priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int total = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < n-1; i++) {

            priorityQueue.add(arr[i]);
            count++;
            if(count<3 && arr[i]==priorityQueue.peek()){
                //연속 3번이 아니고 배열요소가 queue에 max 값이라면
                if(i==n-2 && count==2){ //직전에서 count 2에 걸린다면(마지막 요소 넣기위한)
                    total = total + arr[arr.length-1]; //배열 마지막꺼 넣어주고 break;
                    break;
                }else {
                    total = total + priorityQueue.poll();
                }
            }else{
                priorityQueue.poll();
                count = 0;
            }
        }

        System.out.println(total);

    }
}
