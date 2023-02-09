import java.io.*;
import java.util.StringTokenizer;

public class N_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int min = 0;
            int max = 0;

            for (int j = 1; j <= a&& j<= b; j++) {
                if(a%j==0 && b%j==0){
                    max = j;
                }
            }
            min = (a*b)/max;
            bw.write(min+"\n");

        }
        bw.flush();
        bw.close();
    }
}
