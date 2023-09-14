import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_13335_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> trucks = new ArrayDeque<>();
        ArrayDeque<Integer> bridge = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks.addLast(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < w; i++) {
            bridge.addLast(0); // 공간만 형성 해준다
        }

        int sum = 0;
        int time = 0;

        while(!bridge.isEmpty()){
            sum = sum - bridge.pollFirst();
            if(!trucks.isEmpty()){
                if(sum + trucks.peekFirst() <= l){
                    int truck = trucks.pollFirst();
                    sum = sum + truck;
                    bridge.addLast(truck);
                }else{
                    bridge.addLast(0);
                }
            }
            time ++;
        }

        System.out.println(time);
    }
}
