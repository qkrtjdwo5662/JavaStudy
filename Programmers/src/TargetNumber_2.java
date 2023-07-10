public class TargetNumber_2 {
    public static int[] numbers = {1,1,1,1,1};
    public static int target = 3;
    public static int answer = 0;
//    public static int[] numbers = {4,1,2,1};
//    public static int target = 4;
    public static void main(String[] args) {
        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target){
        dfs(0, target, 0, numbers);

        return answer;
    }
    public static void dfs(int depth, int target, int sum, int[] numbers){
        if(depth == numbers.length){
            if(target == sum) answer++;
        }else{
            dfs(depth+1, target, sum+numbers[depth], numbers);
            dfs(depth+1, target, sum-numbers[depth], numbers);
        }

    }
}
