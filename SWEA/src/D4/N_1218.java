package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class N_1218 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc= 10;
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        map.put('<', '>');

        for (int i = 1; i <= 10 ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            boolean check = false;
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < s.length(); j++) {
                if(map.containsKey(s.charAt(j))){ // 여는 괄호
                    stack.add(s.charAt(j));
                }else{ // 닫는 괄호
                    if(stack.isEmpty()){
                        check = true;
                        break;
                    }else{
                        if(s.charAt(j)!= map.get(stack.pop())){
                            check = true;
                            break;
                        }
                    }
                }
            }
            if(check) {
                sb.append("#").append(i).append(" ").append(0).append("\n");
                continue;
            }

            if(!stack.isEmpty()) {
                sb.append("#").append(i).append(" ").append(0).append("\n");
                continue;
            }

            sb.append("#").append(i).append(" ").append(1).append("\n");
        }
        System.out.println(sb);
    }
}
