import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class N_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Character> stack = new LinkedList<>();

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            stack.addLast(s.charAt(i));
        }


        int n = Integer.parseInt(br.readLine());

        int cursor = stack.size();
        for (int i = 0; i < n; i++) {
            String t = br.readLine();
            switch (t.charAt(0))
            {
                case 'P':
                    stack.add(cursor,t.charAt(2));
                    cursor = cursor+1;
                    break;
                case 'B':
                    if(cursor==0){
                        break;
                    }else {
                        stack.remove(cursor-1);
                        cursor--;
                    }
                    break;
                case 'L':
                    if(cursor<=0){
                        cursor=0;
                    }else cursor= cursor-1;
                    break;
                case 'D':
                    if(cursor>= stack.size()){
                        cursor= stack.size();
                    }else cursor = cursor+1;
                    break;
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pollFirst());
        }
    }
}
