import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][]arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i][0] = start;
            arr[i][1] = end;
        }


        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] == o2[1]){
                return Integer.compare(o1[0], o2[0]);
            }else return Integer.compare(o1[1], o2[1]);

        }); // 종료시점을 기준으로 정렬

        int now = 0;
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            int first = arr[i][0];
            int end = arr[i][1];
            if(now<= first) {
                now = end;
                answer ++;
            }
        }

        System.out.println(answer);
    }
}
