public class ExpressionAsNumber {
    public static int n = 15;
    public static int answer;
    public static void main(String[] args) {
        System.out.println(solution(n));
    }

    public static int solution(int n){
        answer = 0;

        int mid = n/2;

        for (int i = 1; i <= mid ; i++) {
            dfs(i, i, n);
        }

        return answer+1;
    }

    public static void dfs(int start, int sum, int n){
        if(sum == n){
            answer++;
            return;
        }

        if(n >= sum + start + 1){
            dfs(start+1, sum + start+1, n);
        }

    }
}
