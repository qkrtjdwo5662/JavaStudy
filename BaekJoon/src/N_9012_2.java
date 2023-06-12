import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class N_9012_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        HashMap<Character, Character> hashMap= new HashMap<>();

        hashMap.put('(',')');
        hashMap.put('[',']');
        hashMap.put('{','}');

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            String answer = "YES";
            boolean flag = false;

            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < s.length(); j++) {
                char now = s.charAt(j);
                if(hashMap.containsKey(now)){
                    stack.push(now);
                }else{
                    if(stack.isEmpty()){
                        sb.append("NO").append("\n");
                        flag = true;
                        break;
                    }else if(now != hashMap.get(stack.pop())){
                        sb.append("NO").append("\n");
                        flag = true;
                        break;
                    }
                }
            }
            if(flag){
                continue;
            }

            if(stack.isEmpty()){
                sb.append(answer).append("\n");
            }else{
                answer = "NO";
                sb.append(answer).append("\n");
            }
        }
        System.out.println(sb);
        
    }
}
