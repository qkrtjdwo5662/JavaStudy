import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <=n ; i++) {
            queue.addLast(i);
        }
        //1 ~ n 까지 큐에 넣기

        int count =0;
        System.out.print("<");
        while(queue.size()!=1){
            if(count!=k-1){
                queue.addLast(queue.pollFirst());
                count ++;
            }else{
                System.out.print(queue.pollFirst()+", ");
                count =0;
            }
        }
        System.out.println(queue.pollFirst()+">");



    }
}
