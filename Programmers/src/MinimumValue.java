public class MinimumValue {
    public static int[] A = {1, 2};
    public static int[] B = {3, 4};
    public static int answer;
    public static void main(String[] args) {
        System.out.println(solution(A, B));
    }

    public static int solution(int[] A, int[] B){
        answer = Integer.MAX_VALUE;
        int n = A.length;

        boolean[] visited = new boolean[n];

        backtrack(0, n, A, B,visited,0);
        return answer;
    }

    public static void backtrack(int depth, int n, int[] A, int[] B, boolean[] visited, int total){
        if(depth == n){
            answer = Math.min(answer, total);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                if(total + A[depth] * B[i] < answer){
                    backtrack(depth+1, n, A, B, visited, total + A[depth] * B[i]);
                }
                visited[i] = false;
            }

        }
    }
}
