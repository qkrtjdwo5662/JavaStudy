import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_584 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] first_arr = new int[n][2];
        int[][] second_arr = new int[m][2];

        int answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            first_arr[i][0] = height;
            first_arr[i][1] = speed;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            second_arr[i][0] = height;
            second_arr[i][1] = speed;
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = index; j < m; j++) {
                if(first_arr[i][0] < second_arr[j][0]){
                    second_arr[j][0] = second_arr[j][0] - first_arr[i][0];
                    if(second_arr[j][1] > first_arr[i][1]) answer = Math.max(answer, second_arr[j][1] - first_arr[i][1]);
                    break;
                }else if(first_arr[i][0] > second_arr[j][0]){
                    first_arr[i][0] = first_arr[i][0] - second_arr[j][0];
                    if(second_arr[j][1] > first_arr[i][1]) answer = Math.max(answer, second_arr[j][1] - first_arr[i][1]);
                    index++;
                }else{
                    if(second_arr[j][1] > first_arr[i][1]) answer = Math.max(answer, second_arr[j][1] - first_arr[i][1]);
                    index++;
                    break;
                }
            }
        }

        System.out.println(answer);


    }
}
