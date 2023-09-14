import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> truck = new ArrayDeque<>();
        ArrayDeque<Integer> bridge = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(st.nextToken());
            truck.addLast(data);
        }

        for (int i = 0; i < w; i++) {
            bridge.addLast(0); // 다리길이 만큼 0넣기
        }

        int time =0;
        int sum = 0;
        while(!bridge.isEmpty()){
            System.out.println(bridge);
            sum = sum - bridge.pollFirst();
            if(!truck.isEmpty()){
                if(sum + truck.peekFirst() <= l){
                    int now = truck.pollFirst();
                    sum = sum + now;
                    bridge.addLast(now);
                    System.out.println(bridge);
                }else{
                    bridge.addLast(0);
                    System.out.println(bridge);
                }
            }
            time++;
        }
        System.out.println(time);
    }
}
