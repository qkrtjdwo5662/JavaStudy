package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = 10;
        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            ArrayDeque<Integer> deque = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 8; j++) {
                int num = Integer.parseInt(st.nextToken());
                deque.addLast(num);
            } // deque 세팅

            int index = 1;

            while(deque.peekFirst() - index > 0){
                int poll = deque.pollFirst();

                poll = poll - index;
                index += 1;

                if(index > 5) index -= 5;
                deque.addLast(poll);
            }
            deque.pollFirst();
            deque.addLast(0);

            sb.append("#").append(i);
            while(!deque.isEmpty()){
                sb.append(" ").append(deque.pollFirst());
            }
            sb.append("\n");

        }

        System.out.println(sb);
    }
}
