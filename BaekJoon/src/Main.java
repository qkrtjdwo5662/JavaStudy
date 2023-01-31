import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push":
                    int m = Integer.parseInt(st.nextToken());
                    stack.addLast(m);
                    break;
                case "pop":
                    if(!stack.isEmpty()){
                        System.out.println(stack.pollLast());
                    }else System.out.println(-1);
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if(!stack.isEmpty()){
                        System.out.println(0);
                    }else System.out.println(1);
                    break;
                case "top":
                    if(!stack.isEmpty()){
                        System.out.println(stack.peekLast());
                    }else System.out.println(-1);
            }
        }
    }
}