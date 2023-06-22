import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class N_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            arrayDeque.addLast(i);
        }

        while(arrayDeque.size()>1){
            arrayDeque.pollFirst(); // 한장 버리고
            arrayDeque.addLast(arrayDeque.pollFirst()); // 그 다음 한장 밑으로
        }

        int answer = 0;
        answer = arrayDeque.pollFirst();

        System.out.println(answer);
    }
}
