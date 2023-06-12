import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class N_17298_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();



        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n-1; i>=0 ; i--) {
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                answer[i] = -1;
            }else{
                answer[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.print(sb);
    }
}
