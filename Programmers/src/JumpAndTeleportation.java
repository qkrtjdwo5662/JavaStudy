public class JumpAndTeleportation {
    public static int n = 5000;

    public static int answer;
    public static void main(String[] args) {
        System.out.println(solution(n));
    }

    public static int solution(int n){
        answer =Integer.MAX_VALUE;
        // k 칸 점프, 건전지 사용
        // 현재온거리 X2 순간이동, 건전지 사용 X

        dfs(1, n, 1);
        return answer;
    }

    public static void dfs(int now, int n, int count){
        if(now > n) return;

        if(count >= answer) return;

        if(now == n){
            answer = count;
            return;
        }

        dfs(now+1, n, count+1);
        dfs(now*2, n, count);
    }

}
