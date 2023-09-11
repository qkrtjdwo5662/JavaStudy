public class TargetNumber_6 {
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

    public static void dfs(int depth, int sum, int[] numbers, int target){
        if(depth == numbers.length){
            if(sum == target) answer++;
            return;
        }
        dfs(depth+1, sum-numbers[depth], numbers, target);
        dfs(depth+1, sum+numbers[depth], numbers, target);

    }
}
