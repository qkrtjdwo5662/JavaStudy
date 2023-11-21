package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_9280 {
    public static int n;
    public static int[] cost;
    public static int[] weight;
    public static boolean[] visit;
    public static int[] now;
    public static int answer;
    public static ArrayDeque<Integer> wait;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 주차 공간 개수
            int m = Integer.parseInt(st.nextToken()); // 차량 수

            // 출차 시에 계산한다.

            cost = new int[n]; // 비용
            visit = new boolean[n]; // 주차공간에 차량 있는지
            now = new int[n]; // 주차공간에 어떤 차 있는지
            wait = new ArrayDeque<>();
            answer = 0;
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                cost[j] = num;
            } // 주차공간 요금

            weight = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                weight[j] = num;
            } // 차량 별 무게

            for (int j = 0; j < 2*m; j++) {
                st = new StringTokenizer(br.readLine());

                int opr = Integer.parseInt(st.nextToken());

                if(opr > 0){ // 입차
                    // 주차 공간 여부 확인
                    if(check() != -1){
                        now[check()] = opr;
                        visit[check()] = true;
                    }else{
                        wait.addLast(opr); // 차량 대기
                    }

                }else{ // 출차
                    int car = Math.abs(opr);
                    exitCar(car);

                }

            }


            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
    public static void exitCar(int car){
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (now[i] == car) {
                index = i;
                break;
            }
        }

        visit[index] = false;
        answer = answer + cost[index] * weight[car];

        if(wait.size() > 0){
            int poll = wait.pollFirst();
            now[index] = poll;
            visit[index] = true;
        }

    }
    public static int check(){
        for (int i = 0; i < n; i++) {
            if(!visit[i]){ // 비어있는 곳
                return i;
            }
        }

        return -1;
    }
}
