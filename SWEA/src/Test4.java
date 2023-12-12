public class Test4 {
//    public static String[] arr = {"1", "2", "3", "4"};
    public static int n;
    public static boolean[] visited;
    public static void main(String[] args) {
        n = 4;
        visited = new boolean[n];
        backtrack(0, "");

        System.out.println("-----------");

        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    System.out.println(i + "" + j + "" + k);
                }
            }
        }
    }

    public static void backtrack(int depth, String s){
        if(depth == n-1){
            System.out.println(s);
            return;
        }

        for (int i = depth; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                backtrack(depth+1, s+i);
                visited[i] = false;
            }
        }
    }
}
