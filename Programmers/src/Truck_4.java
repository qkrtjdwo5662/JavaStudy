import java.util.ArrayDeque;

public class Truck_4 {
    public static int bridge_length = 2;
    public static int weight = 10;
    public static int[] truck_weights = {7,4,5,6};

    public static void main(String[] args) {
        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights){
        ArrayDeque<Integer> truck = new ArrayDeque<>();
        ArrayDeque<Integer> bridge = new ArrayDeque<>();

        int answer = 0;

        for (int i = 0; i < truck_weights.length; i++) {
            truck.addLast(truck_weights[i]);
        }

        for (int i = 0; i < bridge_length; i++) {
            bridge.addLast(0);
        }


        int sum = 0; // 총 무게 합산
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
