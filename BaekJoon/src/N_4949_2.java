import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class N_4949_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(',')');
        hashMap.put('[',']');
        hashMap.put('{','}');



        while(true){
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            String answer ="yes";
            boolean flag = false;
            if(s.charAt(0)=='.'){
                break;
            }
            for (int i = 0; i < s.length(); i++) {
                char now = s.charAt(i);
                if (hashMap.containsKey(now)) {
                    stack.push(now);
                } else {
                    if (hashMap.containsValue(now)) { // 닫는 괄호인지
                        if (stack.isEmpty()) {
                            sb.append("no").append("\n");
                            flag = true;
                            break;
                        } else if (now != hashMap.get(stack.pop())) {
                            sb.append("no").append("\n");
                            flag = true;
                            break;
                        }
                    }
                }
            }
            if(flag){
                continue;
            }

            if(stack.isEmpty()){
                sb.append(answer).append("\n");
            }else{
                answer = "no";
                sb.append(answer).append("\n");
            }
        }


        System.out.print(sb);

    }
}
