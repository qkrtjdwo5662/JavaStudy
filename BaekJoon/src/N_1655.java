import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class N_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] mid = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            int data = Integer.parseInt(br.readLine());

            if(i==1) mid[i] = data;
            pq.add(data);
            if(i%2 != 0){ // 홀수 번째

            }else{ // 짝수 번째
                
            }
        }
    }
}
