import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class N_11478_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int answer =0;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length()-i; j++) {
                if(!set.contains(s.substring(j, i+j + 1))){
                    answer++;
                    set.add(s.substring(j, i+j + 1));
                }
            }
        }
        System.out.println(answer);


    }
}
