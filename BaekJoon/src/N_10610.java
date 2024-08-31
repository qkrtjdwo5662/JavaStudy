import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_10610 {
    static List<Integer> list;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String s = st.nextToken();
        list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i) - '0');
        }

        Collections.sort(list);

        for (int i = list.size() - 1; i >=0; i--) {
            sb.append(list.get(i));
        }

        int num = Integer.parseInt(sb.toString());

        if(num % 30 == 0) {
            System.out.println(num);
        }else System.out.println(-1);

    }

}
