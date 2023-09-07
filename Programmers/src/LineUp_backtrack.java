import java.util.Arrays;

public class LineUp_backtrack {
    public static int n = 3;
    public static long k = 5;
    public static long count = 0;
    public static int[] answer;
    public static boolean[] visited;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(n, k)));
    }

    public static int[] solution(int n, long k){
        answer = new int[n];
        visited = new boolean[n+1];
        backtrack(n, "", k);
        return answer;
    }

    public static void backtrack(int n, String s, long k){
        if(s.length() == n){
            count++;
            if(count == k){
                for (int i = 0; i < s.length(); i++) {
                    answer[i] = s.charAt(i) -'0';
                }
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                visited[i] = true;
                backtrack(n, s+i, k);
                visited[i] = false;
            }
        }
    }
}
