import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            if(k==0 && !stack.isEmpty()){
                stack.pop();
                continue;
            }
            stack.push(k);
        }

        while(!stack.isEmpty()){
            answer = answer + stack.pop();
        }
        System.out.println(answer);

    }
}
