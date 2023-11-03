import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class N_11478_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        // ababc

        // a, b, a, b, c
        // ab, ba, ab, bc
        // aba, bab, abc
        // abab, babc
        // ababc

        HashMap<String, Integer> map = new HashMap<>();
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length()-i; j++) {
                String s1 = s.substring(j, j+i+1);
                if(!map.containsKey(s1)){
                    map.put(s1, 0);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
