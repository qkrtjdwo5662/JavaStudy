package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_4408_fail_2 {
    public static void main(String[] args) throws IOException {
        // 1 ~ 2 // 3 ~ 4 // 5 ~ 6 홀-짝이 하나의 통로를 공유하고 있다고 본다.
        // 방의 시작 ~ 목표까지 방문체크
        // 방문체크가 되어있다면 기다려야함 + 1 증가
        // 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][2];

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                int now = Integer.parseInt(st.nextToken());
                int target = Integer.parseInt(st.nextToken());

                arr[j][0] = now;
                arr[j][1] = target;

                max = Math.max(max, Math.max(now, target));
                min = Math.min(min, Math.min(now, target));
            }

            boolean[] visited = new boolean[(max + 1)/2 + 1]; // 가장 큰 값으로 방문 체크 배열 생성

            int answer = 1;
            int equal = 0;
            for (int j = 0; j < n; j++) {
                boolean check = false;
                int start = 0;
                int end = 0;
                if(arr[j][0] < arr[j][1]){
                    if(arr[j][0] % 2 ==0){
                        start = arr[j][0] / 2;
                    }else{
                        start = (arr[j][0] + 1) / 2;
                    }

                    if(arr[j][1] % 2 == 0){
                        end = arr[j][1] / 2;
                    }else{
                        end = (arr[j][1] + 1) / 2;
                    }

                    for (int k = start; k <= end; k++) {
                        if(!visited[k]){
                            visited[k] = true;
                        }else check = true;
                    }
                }else if(arr[j][0] > arr[j][1]){
                    if(arr[j][0] % 2 ==0){
                        end = arr[j][0] / 2;
                    }else{
                        end = (arr[j][0] + 1) / 2;
                    }

                    if(arr[j][1] % 2 == 0){
                        start = arr[j][1] / 2;
                    }else{
                        start = (arr[j][1] + 1) / 2;
                    }

                    for (int k = start; k <= end; k++) {
                        if(!visited[k]){
                            visited[k] = true;
                        }else check = true;
                    }
                }else{
                    equal += 1;
                }

                if(check) answer ++;
            }
            if(equal == n) {
                sb.append("#").append(i).append(" ").append(0).append("\n");
                continue;
            }
            sb.append("#").append(i).append(" ").append(answer).append("\n");

        }
        System.out.println(sb);
    }
}
