import java.util.ArrayDeque;

public class RemoveMate {
    public static String s = "baabaa";
    public static void main(String[] args) {
        System.out.println(solution(s));
    }

    public static int solution(String s){
        int n = s.length();
        ArrayDeque<java.lang.Character> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if(!deque.isEmpty() && deque.peekLast() == c) deque.pollLast();
            else deque.addLast(c);
        }

        if(deque.isEmpty()){
            return 1;
        }else return 0;
    }
}
