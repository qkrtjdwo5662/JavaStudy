import java.io.*;
import java.util.ArrayDeque;

public class N_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Character>stack = new ArrayDeque<>();
        String s = br.readLine();



        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='<'){
                if(stack.isEmpty()) {
                    while (s.charAt(i) != '>') {
                        stack.addLast(s.charAt(i));
                    }
                    stack.addLast('>');
                    while (!stack.isEmpty()) {
                        System.out.print(stack.pollFirst());
                    }
                }else{
                    while (!stack.isEmpty()) {
                        System.out.print(stack.pollLast());
                    }
                }
            }
            else if(s.charAt(i)==' '){
                while (!stack.isEmpty()) {
                    System.out.print(stack.pollLast());
                }
            }else{

            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pollFirst());
        }
    }
}
