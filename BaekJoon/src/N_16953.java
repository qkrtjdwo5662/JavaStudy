import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long start = Long.parseLong(st.nextToken());
        long target = Long.parseLong(st.nextToken());

        if(start == target) {
            System.out.println(1);
            return;
        }

        boolean[] visited = new boolean[(int) target]; // 0 ~ target
        ArrayDeque<Long> arrayDeque = new ArrayDeque<>();

        visited[(int) start] = true;
        arrayDeque.addLast(start);
        // 초기화
        int answer = 1;
        int size = arrayDeque.size();  // 초기 size

        while(size > 0){
            size = arrayDeque.size(); // size update
            answer++;

            for (int i = 0; i < size; i++) {
                long now = arrayDeque.pollFirst(); // 하나 꺼내고
                long first = now * 2; // X 2
                long second = now *10 + 1; // 숫자 오른쪽에 1 추가


                if(first == target || second == target){
                    System.out.println(answer);
                    return;
                }

                if(first<= target && !visited[(int) first]){
                    visited[(int) first] = true;
                    arrayDeque.addLast(first);
                }

                if(second<= target && !visited[(int) second]){
                    visited[(int) second] = true;
                    arrayDeque.addLast(second);
                }
            }
        }
        System.out.println(-1); // 반복문 탈출하면, size가 0이라면
    }
}
