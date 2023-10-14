package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1984 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            int[] arr = new int[10];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[j] = num;
            }

            Arrays.sort(arr);
            double sum = 0;
            for (int j = 1; j < 9; j++) {
                sum = sum + arr[j];
            }


            sb.append("#").append(i).append(" ").append(Math.round(sum/8)).append("\n");

        }
        System.out.println(sb);
    }
}

// 소수점 첫째자리에서 반올림 메소드 Math.round()
// 정수형으로 Math.round(정수 / 정수)사용하면 반올림 안됨
// Math.round(실수 / 정수)로 