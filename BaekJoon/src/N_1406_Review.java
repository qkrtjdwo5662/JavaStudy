import java.io.*;
import java.util.Stack;

public class N_1406_Review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> firstStack = new Stack<>();
        Stack<Character> lastStack = new Stack<>();

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            firstStack.push(s.charAt(i));
        }
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String k = br.readLine();
            switch (k.charAt(0)){
                case 'D':
                    if(!lastStack.isEmpty()){
                        firstStack.push(lastStack.pop());
                    }else break;
                    break;
                case 'L':
                    if(!firstStack.isEmpty()){
                        lastStack.push(firstStack.pop());
                    }else break;
                    break;
                case 'P':
                    firstStack.push(k.charAt(2));
                    break;
                case 'B':
                    if(!firstStack.isEmpty()){
                        firstStack.pop();
                    }else break;
            }
        }
        while(!firstStack.isEmpty()){
            lastStack.push(firstStack.pop());
        }
        while (!lastStack.isEmpty()){
            bw.write(lastStack.pop());
        }
        bw.flush();
        bw.close();
    }
}
