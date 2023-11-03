import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class week_4_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        // ababc

        // a, b, a, b, c
        // ab, ba, ab, bc
        // aba, bab, abc
        // abab, babc
        // ababc
//        ArrayList<String> list = new ArrayList<>();
//        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length()-i; j++) {
                String s1 = s.substring(j, j+i+1);
                set.add(s1);
            }
        }

        System.out.println(set.size());

    }
}
