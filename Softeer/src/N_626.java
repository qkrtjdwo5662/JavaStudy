import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 회의실 개수
        int m = Integer.parseInt(st.nextToken()); // 회의 예약 수

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
        }
            
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
        }
    }
}
