public class Test_2 {
    public static int[] a = {1,2,3,4};
    public static boolean[] visited;
    public static void main(String[] args) {
        visited = new boolean[a.length];
        backtrack("");
    }

    public static void backtrack( String s){
//        System.out.println(s.length());
        if(s.length() == a.length) {
            System.out.println(s);
            return;
        }

        for (int i = 0; i < a.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                backtrack(s + a[i]);
                visited[i] = false;
            }

        }
    }
}
