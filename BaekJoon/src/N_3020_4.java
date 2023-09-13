import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_3020_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][] arr = new int[h][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int data = Integer.parseInt(st.nextToken());

            if(i%2==0){
                for (int j = 0; j < data; j++) {
                    arr[j][i] = 1;
                }
            }else{
                for (int j = h-1; j >= h-data ; j--) {
                    arr[j][i] = 1;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int[] answer = new int[h];
        for (int i = 0; i < h; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1) sum++;
            }
            min = Math.min(min, sum);
            answer[i] = sum;
        }

        int count= 0;
        for (int i = 0; i < h; i++) {
            if(min == answer[i]) count++;
        }

        System.out.println(min + " " + count);

    }
}
