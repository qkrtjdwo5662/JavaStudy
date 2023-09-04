public class test{
    public static boolean[] visited;
    public static void main(String[] args) {
        visited = new boolean[4];
        dfs("");
    }

    public static void dfs(String s){

        if(s.length() == 4){
            System.out.println(s);
            return;
        }

        for (int i = 0; i <4 ; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(s+i);
                visited[i] = false;
            }

        }
    }
}
