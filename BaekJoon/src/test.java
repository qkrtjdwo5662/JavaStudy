
public class test {
    public static boolean visited[];
    public static void main(String[] args)  {
        int n = 4;
        visited = new boolean[n+1];
        backtrack("", n);

    }
    public static void backtrack(String s, int n){
        if(s.length()==2){
            System.out.println(s);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                visited[i] = true;
                backtrack(s+i, n);
                visited[i] = false;
            }
        }
    }
}
