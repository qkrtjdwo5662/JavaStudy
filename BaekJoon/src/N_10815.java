import java.io.*;
import java.util.StringTokenizer;

public class N_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st =new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int arr_n[] = new int[n];
        for (int i = 0; i <n ; i++) {
            arr_n[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int arr_m[] = new int[m];
        int check[] = new int[m];
        for (int i = 0; i < m; i++) {
            arr_m[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                if(arr_m[i]==arr_n[j]){
                    check[i] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.print(check[i]+" ");
        }


    }
}
