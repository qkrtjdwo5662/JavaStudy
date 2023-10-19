
public class TargetNumber_7 {
    public static int[] numbers = {1,1,1,1,1};
    public static int target = 3;
    public static int answer;
    public static void main(String[] args) {
        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target){
        answer = 0;


        dfs(0, 0, numbers, target);

        return answer;
    }

    public static void dfs(int idx, int now , int[] numbers, int target){
        if(idx == numbers.length){
            if(now == target) {
                answer++;
            }
            return;
        }

        dfs(idx+1, now+numbers[idx], numbers, target);
        dfs(idx+1, now-numbers[idx], numbers, target);

    }
}
