import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        if(start == end){
            System.out.println(0);
            return;
        }

        boolean[] visited = new boolean[100_000 + 1];
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        visited[start] = true;
        arrayDeque.addLast(start);
        int count = 0;
        while(true){
            count ++;
            int size = arrayDeque.size();
            for (int i = 0; i < size; i++) {
                int now = arrayDeque.pollFirst();

                int x1 = now - 1;
                int x2 = now + 1;
                int x3 = now * 2;



                if(x1 == end || x2 == end || x3 == end){
                    System.out.println(count);
                    return;
                }
                if((x1 >= 0 && x1<= 100_000) && !visited[x1]){ // 범위 안 이고 방문하지 않았으면
                    visited[x1] = true;
                    arrayDeque.addLast(x1);
                }

                if((x2 >= 0 && x2<= 100_000) && !visited[x2]){ // 범위 안 이고 방문하지 않았으면
                    visited[x2] = true;
                    arrayDeque.addLast(x2);
                }

                if((x3 >= 0 && x3<= 100_000) && !visited[x3]){ // 범위 안 이고 방문하지 않았으면
                    visited[x3] = true;
                    arrayDeque.addLast(x3);
                }

            }

        }
    }
}
