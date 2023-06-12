import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class N_4949_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(',')');
        hashMap.put('[',']');
        // key : (, [
        // value : ), ]

        while(true){
            String s = br.readLine(); // 입력 받은 문자
            Stack<Character> stack = new Stack<>(); // 스택 초기화

            if(s.charAt(0)=='.') break; // 입력받은 문자가 . 이라면 종료

            boolean flag = false; // 이미 no가 되었는지 확인

            for (int i = 0; i < s.length(); i++) {
                char now = s.charAt(i); // index로 문자열 접근

                if(hashMap.containsKey(now)){ // 이미 hash에 존재하는 키라면 , 여는 괄호라면
                    stack.push(now);
                } else if (hashMap.containsValue(now)) { // 이미 hash에 존재하는 value라면 , 닫는 괄호라면
                   if(stack.isEmpty()){  // 스택이 비어있다면 no
                       flag = true;
                       sb.append("no").append("\n");
                       break;
                   }else{ // 짝 맞는지 확인
                       if(now!=hashMap.get(stack.pop())){
                           flag = true;
                           sb.append("no").append("\n");
                           break;
                       }else continue;
                   }

                } else{ // 일반 문자열 이라면
                    continue;
                }
            }

            if(flag){
                continue; // 이미 no가 되었으면 넘김
            }

            if(stack.isEmpty()){ // 최종으로 스택이 비었다면 옳바른 괄호 형식 O
                sb.append("yes").append("\n");
            }else { // 스택이 비어있지 않다면 옳바른 괄호 형식 X
                sb.append("no").append("\n");
            }
        }
        System.out.print(sb);
    }
}
