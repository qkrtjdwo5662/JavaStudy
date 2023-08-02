import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_395 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[] arr = new int[10000+1]; // index : 가격 , arr[index] : 무게
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            arr[p] = arr[p] + m;
        }

        for (int i = arr.length-1; i >0 ; i--) {
            if(arr[i] == 0) continue;
            else{
                if(w > arr[i]) {
                    answer = answer + i*arr[i];
                    w = w-arr[i];
                }else {
                    answer = answer + w*i;
                    System.out.println(answer);
                    return;
                }
            }
        }

    }
}
