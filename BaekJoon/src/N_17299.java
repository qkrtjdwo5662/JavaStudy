import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class N_17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        int n = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        int arr_count[] = new int[1_000_001];
        int answer[] = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());
            arr[i] = k;
            arr_count[arr[i]]++;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr_count[arr[stack.peek()]]<arr_count[arr[i]]){
                answer[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) answer[stack.pop()] = -1;

        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.print(sb);

    }
}
