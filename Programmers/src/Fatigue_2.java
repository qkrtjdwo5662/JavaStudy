public class Fatigue_2 {
    public static int[][] dungeons = {{80,20}, {50, 40}, {30, 10}};
    public static int k = 80;
    public static int answer;
    public static boolean[] visited;
    public static void main(String[] args) {
        System.out.println(solution(k, dungeons));
    }

    public static int solution(int k, int[][] dungeons){
        answer = 0;

        visited = new boolean[dungeons.length];
        backtrack(0, k, dungeons);
        return answer;
    }

    public static void backtrack(int depth, int k, int[][] dungeons){
        if(depth == dungeons.length){
            answer = dungeons.length;
            return;
        }


        for (int i = 0; i < dungeons.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                System.out.println(i);
                if(k >= dungeons[i][0]) {
                    backtrack(depth+1, k-dungeons[i][1], dungeons);
                }
                else {
                    answer = Math.max(answer, depth);
                }
                visited[i] = false;
            }
        }
    }
}
