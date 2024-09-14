import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        int start = s.length()/2;
        boolean flag = false;
        int answer = s.length()*2;
        for (int i = start; i <s.length(); i++) {
            if(i > 0 && s.charAt(i-1) == s.charAt(i)){
                // a b b a
                int len = abba(i, s.length(), s);
                if( len != -1){
                    flag = true;
                    answer = Math.min(answer, s.length() + len);
                }

            }

            if(i<s.length() - 1 && s.charAt(i - 1) == s.charAt(i + 1)){
                // a b a
                int len = aba(i+1, s.length(), s);
                if( len != -1){
                    flag = true;
                    answer = Math.min(answer, s.length() + len);
                }
            }
        }

        if(!flag) answer = s.length() * 2 - 1;

        sb.append(answer).append("\n");
        System.out.println(sb);
    }
    static int aba(int start, int end, String s){
        for (int i = start; i < end; i++) {
            if(s.charAt(i) != s.charAt(start - (i-start) - 2)) return -1;
        }

        return s.length() - 2*(end - start + 1) + 1;
    }

    static int abba(int start, int end, String s){
        for (int i = start; i < end; i++) {
            if(s.charAt(i) != s.charAt(start - (i-start) - 1)) return -1;
        }

        return s.length() - 2*(end - start);
    }
}
