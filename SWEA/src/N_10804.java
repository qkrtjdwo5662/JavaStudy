import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class N_10804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            ArrayDeque<Character> arrayDeque = new ArrayDeque<>();
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == 'b'){
                    arrayDeque.addLast('d');
                } else if (s.charAt(j) == 'd') {
                    arrayDeque.addLast('b');
                } else if (s.charAt(j) == 'p') {
                    arrayDeque.addLast('q');
                } else if (s.charAt(j) == 'q') {
                    arrayDeque.addLast('p');
                }
            }
            while(!arrayDeque.isEmpty()){
                sb.append(arrayDeque.pollLast());
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }
}
