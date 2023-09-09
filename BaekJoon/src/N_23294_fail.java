import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_23294_fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 웹 페이지 종류 수
        int q = Integer.parseInt(st.nextToken()); // 작업의 개수
        int c = Integer.parseInt(st.nextToken()); // 최대 캐시 용

        st = new StringTokenizer(br.readLine());
        int[] cost = new int[n+1];
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int idx = -1; // 현재 페이지
        ArrayDeque<Integer> front = new ArrayDeque<>();
        ArrayDeque<Integer> back =  new ArrayDeque<>();
        int backSize = 0;
        int frontSize = 0;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            if(cmd == 'B'){ // back
                if(!back.isEmpty()){
                    front.addLast(idx); // front에 현재 페이지 넣고
                    frontSize = frontSize + cost[idx];
                    idx = back.pollLast(); // idx 최신화
                    backSize = backSize - cost[idx];

                }

//                    System.out.println("capacity : " + capacity + " idx : " + idx);
            }else if(cmd == 'F'){ // front
//                    System.out.println("front 실행");
                if(!front.isEmpty()) {
                    back.addLast(idx); // back에 현재 페이지 넣고
                    backSize = backSize + cost[idx];
                    idx = front.pollLast(); // idx 최신화
                    frontSize = frontSize - cost[idx];

                }
//                    System.out.println("capacity : " + capacity + " idx : " + idx);
            }else if(cmd == 'A'){
                // access
                int num = Integer.parseInt(st.nextToken());
                // front 비우기
                frontSize = 0;
                front.clear();

                if(idx != -1){ // 웹페이지 첫 방문 X
                    back.addLast(idx); // 뒤로가기에 추가
                    backSize = backSize + cost[idx];
                }
                idx = num; // 현재 페이지 갱신

                while(cost[idx] + backSize + frontSize > c){ // 용량 조정
                    backSize = backSize - cost[back.pollFirst()];
                }

                }else if(cmd == 'C'){ // compression
                    ArrayDeque<Integer> temp = new ArrayDeque<>();
                    int size = back.size();
                    for (int j=0; j< size; j++) {
                        int poll = back.pollFirst();
                        if(temp.isEmpty()) temp.addLast(poll);
                        else{
                            if(poll != temp.peekLast()) temp.addLast(poll);
                            else backSize = backSize - cost[poll];
                        }
                    }

                    back = temp;
              }
        }
        StringBuilder sb = new StringBuilder();

        sb.append(idx).append("\n");

        if(back.isEmpty()){
            sb.append("-1").append("\n");
        }else{
            while(!back.isEmpty()){
                sb.append(back.pollLast()).append(" ");
            }
            sb.append("\n");
        }

        if(front.isEmpty()){
            sb.append("-1");
        }else{
            while(!front.isEmpty()){
                sb.append(front.pollLast()).append(" ");
            }
        }

        System.out.println(sb);
    }
}
