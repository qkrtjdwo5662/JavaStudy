import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_990 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[5];
        int answer = 0;
        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine();
        }


        for (int i = 0; i < 5; i++) {
            String[] day = arr[i].split(" "); // 시작, 끝
            int work = 0;

            String[] hm_end = day[1].split(":"); // 시, 분
            int hour_end = Integer.parseInt(hm_end[0]) * 60; // 시
            int minute_end = Integer.parseInt(hm_end[1]);

            String[] hm_start = day[0].split(":"); // 시, 분
            int hour_start = Integer.parseInt(hm_start[0]) * 60; // 시
            int minute_start = Integer.parseInt(hm_start[1]);

            work = (hour_end-hour_start) + (minute_end-minute_start);

            answer = answer + work;
        }

        System.out.println(answer);
    }
}
