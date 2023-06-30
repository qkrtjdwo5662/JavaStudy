public class Backtracking2 {
    public static int[] num = {1,2,3,4};
    public static boolean[] visited;
    public static void main(String[] args) {
        visited = new boolean[num.length];
        bfs("");
    }
    public static void bfs(String s){
        if(s.length() == num.length){
            System.out.println(s);
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                bfs(s+i);
                visited[i] = false;
            }
        }
    }
}
