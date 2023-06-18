import java.util.ArrayDeque;

public class Truck {
    public static int bridge_length = 2;
    public static int weight = 10;
    public static int[] truck_weights = {7,4,5,6};

    public static void main(String[] args) {
        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights){
        int answer = 0;

        ArrayDeque<Integer> wait = new ArrayDeque<>();

        for (int i = 0; i <truck_weights.length ; i++) {
            wait.addLast(truck_weights[i]);
        }


        return answer;
    }
}
