package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            int n = Integer.parseInt(st.nextToken());
            String[] arr = new String[n + 1];
            for (int j = 1; j <= n ; j++) {
                String s = st.nextToken();
                arr[j] = s;
            }
        }


    }
}
