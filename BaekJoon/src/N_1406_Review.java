import java.io.*;
import java.util.Stack;

public class N_1406_Review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> l_stack = new Stack<>();
        Stack<Character> r_stack = new Stack<>();

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            l_stack.push(s.charAt(i));
        }
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String k = br.readLine();
            switch (k.charAt(0)){
                case 'D':
                    if(!r_stack.isEmpty()){
                        l_stack.push(r_stack.pop());
                    }else break;
                    break;
                case 'L':
                    if(!l_stack.isEmpty()){
                        r_stack.push(l_stack.pop());
                    }else break;
                    break;
                case 'P':
                    l_stack.push(k.charAt(2));
                    break;
                case 'B':
                    if(!l_stack.isEmpty()){
                        l_stack.pop();
                    }else break;
            }
        }
        while(!l_stack.isEmpty()){
            r_stack.push(l_stack.pop());
        }
        while (!r_stack.isEmpty()){
            bw.write(r_stack.pop());
        }
        bw.flush();
        bw.close();
    }
}
