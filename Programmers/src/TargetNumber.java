public class TargetNumber {
//    static int []numbers = {1,1,1,1,1};
    static int []numbers = {4,1,2,1};
    static int answer=0;
    public static void main(String[] args) {
        System.out.println(solution(numbers,4));
    }
    static int solution(int[] numbers, int target){

        dfs(numbers,0,target,0);
        return answer;
    }
    static void dfs(int []numbers, int depth, int target, int sum){
        if(depth==numbers.length){
            if(target==sum) answer++;
        }else{
            dfs(numbers, depth+1, target, sum+numbers[depth]);
            dfs(numbers, depth+1, target, sum-numbers[depth]);
        }
    }

}
