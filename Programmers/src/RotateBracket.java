import java.util.ArrayDeque;

public class RotateBracket {
    static String s ="}]()[{";
    public static void main(String[] args) {
        System.out.println(solution(s));
    }
    static int solution(String s) {
        int answer = 0;
        ArrayDeque<Character>queue = new ArrayDeque<>();
        ArrayDeque<Character>stack = new ArrayDeque<>();
        int index =0;
        while (index!=s.length()){
            queue.clear();
            for (int i = 0; i < s.length(); i++) {
                queue.addLast(s.charAt(i));
            }
            for(int i=0; i<queue.size(); i++){
                if(queue.getLast()!=']'&&queue.getFirst()!=')'&&queue.getFirst()!='}'){
                    stack.addFirst(queue.pollFirst());
                    answer++;
                }else{


                }
                queue.addLast(queue.pollFirst());
            }

            index++;
        }



        return answer;
    }
}
