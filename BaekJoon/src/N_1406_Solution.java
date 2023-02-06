import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class N_1406_Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> lstack = new Stack<>();
        Stack<Character> rstack = new Stack<>();

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            lstack.push(s.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String t = br.readLine();
            switch (t.charAt(0))
            {
                case 'P':
                    lstack.push(t.charAt(2));
                    break;
                case 'B':
                    if(!lstack.isEmpty()) {
                        lstack.pop();
                    }
                    break;
                case 'L':
                    if(!lstack.isEmpty()) {
                        rstack.push(lstack.pop());
                    }
                    break;
                case 'D':
                    if(!rstack.isEmpty()) {
                        lstack.push(rstack.pop());
                    }
                    break;
            }
        }
        while(!lstack.isEmpty())
            rstack.push(lstack.pop());
        while(!rstack.isEmpty())
            bw.write(rstack.pop());

        bw.flush();
        bw.close();
    }
}
