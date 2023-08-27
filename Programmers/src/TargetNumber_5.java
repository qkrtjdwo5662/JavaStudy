    import java.util.ArrayDeque;

public class TargetNumber_5 {
    public static int[] numbers = {4,1,2,1};
    public static int target = 4;
    public static int answer;
    public static void main(String[] args) {
        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target){
        answer = 0;
        bfs(0, numbers, target);
        return answer;
    }

    public static void bfs(int start, int[] numbers, int target){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(start);

        for (int i = 0; i < numbers.length; i++) {
            int size = deque.size();

            for (int j = 0; j < size; j++) {
                int now = deque.pollFirst();
                int next;
                for (int k = 0; k < 2; k++) {
                    if(k==0){
                        next = now + numbers[i];
                    }else{
                        next = now - numbers[i];
                    }
                    if(i == numbers.length-1){
                        if(next == target){
                            answer++;
                        }
                    }

                    deque.addLast(next);
                }
            }

        }
    }
}
