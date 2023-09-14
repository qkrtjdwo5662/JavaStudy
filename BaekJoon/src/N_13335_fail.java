import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_13335_fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(st.nextToken());
            arrayDeque.addLast(data);
        }

        int count = 0;
        while(!arrayDeque.isEmpty()){
            int now = arrayDeque.pollFirst();

            count = count + w;

            while(!arrayDeque.isEmpty() && now + arrayDeque.peekFirst() <= l){
                now = now + arrayDeque.pollFirst();
                count = count + 1;
            }
        }

        System.out.println(count+1);
    }
}
