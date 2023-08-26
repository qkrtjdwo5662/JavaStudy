public class TargetNumber_4 {
    public static int[] numbers = {4,1,2,1};
    public static int target = 4;
    public static int answer;
    public static void main(String[] args) {
        System.out.println(solution(numbers, target));
    }
    public static int solution(int[] numbers, int target){
        answer = 0;

        dfs(0, 0, numbers, target);

        return answer;
    }
    public static void dfs(int depth, int num, int[] numbers, int target){
        if(depth == numbers.length){
            if(num == target) answer++;
        }else{
            dfs(depth+1, num + numbers[depth], numbers, target);
            dfs(depth+1, num - numbers[depth], numbers, target);
        }
    }
}
