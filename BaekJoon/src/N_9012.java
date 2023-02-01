import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class N_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s;
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j)=='('){
                    stack.addLast('(');
                }else if(s.charAt(j)==')'){
                    if(stack.contains('(')){
                        stack.pollLast();
                    }else stack.addLast(')');
                }
            }
            if(!stack.isEmpty()){
                System.out.println("NO");
            }else System.out.println("YES");

            stack.clear();
        }
    }
}
