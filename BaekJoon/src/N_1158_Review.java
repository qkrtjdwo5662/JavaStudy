import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_1158_Review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n ; i++) {
            queue.addLast(i);
        }
        int index = 0;

        bw.write("<");
        while(queue.size()>1){
            index ++;
            if(index==k){
                bw.write(queue.pollFirst()+", ");
                index = 0;
                continue;
            }
            queue.addLast(queue.pollFirst());
        }
        bw.write(queue.pollFirst()+">");
        bw.flush();
        bw.close();
    }
}
