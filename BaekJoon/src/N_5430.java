import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());


        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String p = st.nextToken();

            boolean flag = false;
            boolean R_check = false;

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), "[],");

            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }

            if(deque.size()==0){
                sb.append("error").append("\n");
                continue;
            }


            for (int j = 0; j < p.length(); j++) {
                if(p.charAt(j)=='R'){ // R
                    R_check = !R_check; // 방향 바꾸기
                }else{ // D
                    if(!deque.isEmpty()){ // 비었는지 체크
                        if(R_check){ // 방향 체크
                            deque.pollLast();
                        }else deque.pollFirst();
                    }else{ // 비었으면 error
                        flag = true;
                        sb.append("error").append("\n");
                        break;
                    }

                }
            }

            if(flag) continue; // 이미 error 찍힌거면 continue

            //밑은 위의 작업 다 통과한 결과
            if(deque.isEmpty()) { // 비었으면
                sb.append("[]").append("\n");
                continue;
            }

            // 안비었으면
            sb.append("[");
            while(deque.size()>1){
                if(R_check){
                    sb.append(deque.pollLast()).append(",");
                }else{
                    sb.append(deque.pollFirst()).append(",");
                }
            }
            sb.append(deque.pollFirst());
            sb.append("]").append("\n");
        }
        System.out.print(sb);
    }
}
