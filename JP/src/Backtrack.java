public class Backtrack {
    public static char[] alpha = {'A','B','C','D'};
    public static boolean[] visited = new boolean[4];
    public static void main(String[] args) {
        backtrack("");
    }
    public static void backtrack(String s){
        if(s.length()==4){
            System.out.println(s);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(!visited[i]){
                visited[i] = true; // 열어주고
                backtrack(s+alpha[i]); // 방문 안한 것들 만 추가 (중복 제거)
                visited[i] = false; // 잠궈주고
            }

        }
    }
}
