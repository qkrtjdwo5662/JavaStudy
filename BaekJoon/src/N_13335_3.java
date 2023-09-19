import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_13335_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> trucks = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            trucks.addLast(Integer.parseInt(st.nextToken()));
        }

        ArrayDeque<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < w; i++) {
            bridge.addLast(0);
        }

        int sum = 0;
        int answer = 0;
        while(!bridge.isEmpty()){
            sum = sum - bridge.pollFirst();

            if(!trucks.isEmpty()){
                if(sum + trucks.peekFirst() <= l){
                    int poll = trucks.pollFirst();
                    sum = sum + poll;
                    bridge.addLast(poll);
                }else{
                    bridge.addLast(0);
                }
            }
            answer++;
        }
        System.out.println(answer);


    }
}
