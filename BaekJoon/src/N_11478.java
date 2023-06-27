import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class N_11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length()-i; j++) {
                hashMap.put(s.subSequence(j, j + i + 1).toString(), 0);
            }
        }

        System.out.println(hashMap.size());
    }
}
