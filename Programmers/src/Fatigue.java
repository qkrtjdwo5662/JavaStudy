public class Fatigue {
    public static int k = 80;
    public static int[][] dungeons= {{80, 20}, {50, 40}, {30, 10}};
    public static boolean[] visited;
    public static int answer= -1;
    public static void main(String[] args) {
        System.out.println(solution(k, dungeons));
    }

    public static int solution(int k, int[][] dungeons){
        visited = new boolean[dungeons.length];
        backtrack(k, dungeons, 0);

        return answer;
    }

    public static void backtrack(int k, int[][] dungeons, int depth){
        if(depth == dungeons.length){
            answer = Math.max(answer, depth);
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                if(k >= dungeons[i][0]){
                    backtrack(k-dungeons[i][1], dungeons, depth+1);
                }else{
                    answer = Math.max(answer, depth);
                }
                visited[i] = false;
            }
        }
    }
}
