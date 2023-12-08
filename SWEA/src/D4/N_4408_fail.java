package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_4408_fail {
    public static void main(String[] args) throws IOException {
        // 방의 범위가 가장 큰 값 max로 저장하여 방문형 배열 생성
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

            boolean[] visited = new boolean[max + 1]; // 가장 큰 값으로 방문 체크 배열 생성

            int answer = 1;
            int equal = 0;
            for (int j = 0; j < n; j++) {
                boolean check = false;
                if(arr[j][0] < arr[j][1]){
                    for (int k = arr[j][0]; k <= arr[j][1]; k++) {
                        if(!visited[k]){
                            visited[k] = true;
                        }else check = true;
                    }
                }else if(arr[j][0] > arr[j][1]){
                    for (int k = arr[j][1]; k <= arr[j][0]; k++) {
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
