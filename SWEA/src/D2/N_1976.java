package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1976 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());

            int hour1 = Integer.parseInt(st.nextToken());
            int minute1 = Integer.parseInt(st.nextToken());


            int hour2 = Integer.parseInt(st.nextToken());
            int minute2 = Integer.parseInt(st.nextToken());

            int totalHour = 0;
            int totalMinute = 0;

            totalMinute = minute1 + minute2;
            totalHour = hour1 + hour2;

            if(totalMinute >= 60) {
                totalMinute = totalMinute - 60;
                totalHour = totalHour +1;
            }

            if(totalHour > 12){
                totalHour = totalHour-12;
            }

            sb.append("#").append(i).append(" ").append(totalHour).append(" ").append(totalMinute).append("\n");
        }

        System.out.println(sb);
    }
}
