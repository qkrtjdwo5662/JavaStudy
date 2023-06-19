import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sizeQ = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(); // 메인 deque
        ArrayDeque<Integer> tempDeque1; // 두 번쨰 연산을 위한 deque
        ArrayDeque<Integer> tempDeque2; // 세 번쨰 연산을 위한 deque

        for (int i = 1; i <= sizeQ; i++) {
            arrayDeque.addLast(i);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int target = arr[i];
            int secondOp = 0;
            int thirdOp = 0;

            tempDeque1 = arrayDeque.clone();
            tempDeque2 = arrayDeque.clone();

            while(target != tempDeque1.peekFirst()){ // deque empty 발생 상황은 없음.
                tempDeque1.addLast(tempDeque1.pollFirst());
                secondOp++;
            }

            while(target != tempDeque2.peekFirst()){ // deque empty 발생 상황은 없음.
                tempDeque2.addFirst(tempDeque2.pollLast());
                thirdOp++;
            }

            if(secondOp<thirdOp){
                arrayDeque=tempDeque1.clone();
                answer = answer + secondOp;
            }else {
                arrayDeque = tempDeque2.clone();
                answer = answer + thirdOp;
            }

            arrayDeque.pollFirst();
        }
        System.out.println(answer);
    }
}
