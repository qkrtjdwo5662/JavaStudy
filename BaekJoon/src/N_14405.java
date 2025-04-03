import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_14405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String s = st.nextToken();

        s = s.replaceAll("pi|ka|chu", "");

        if(s.equals("")){
            System.out.println("YES");
        }else System.out.println("NO");
    }
}
