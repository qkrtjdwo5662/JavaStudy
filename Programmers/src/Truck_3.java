import java.util.ArrayDeque;

public class Truck_3 {
    public static int bridge_length = 2;
    public static int weight = 10;
    public static int[] truck_weights = {7,4,5,6};

    public static void main(String[] args) {
        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights){
        int answer = 0;
        ArrayDeque<Integer> bridge = new ArrayDeque<>();
        ArrayDeque<Integer> truck = new ArrayDeque<>();

        for (int i = 0; i < bridge_length; i++) {
            bridge.addLast(0);
        }

        for (int i = 0; i < truck_weights.length; i++) {
            truck.addLast(truck_weights[i]);
        }

        int sum =0;
        while(!bridge.isEmpty()){
            sum = sum - bridge.pollFirst();

            if(!truck.isEmpty()){
                if(sum + truck.peekFirst() <= weight){
                    int poll = truck.pollFirst();
                    sum = sum + poll;
                    bridge.addLast(poll);
                }else{
                    bridge.addLast(0);
                }
            }


            answer++;
        }

        return answer;
    }
}
