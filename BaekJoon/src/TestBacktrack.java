public class TestBacktrack {
    public static String[] arr = new String[]{"a", "b", "c", "d"};
    public static void main(String[] args) {
        boolean[] visited = new boolean[4];
        backtrack("", visited, 0);
    }

    public static void backtrack(String s, boolean[] visited, int index){
        if(s.length() == 3){
            System.out.println(s);
            return;
        }

        for (int i = index; i < 4; i++) {
            if(!visited[i]){
                visited[i] = true;
                backtrack(s+arr[i], visited, i);
                visited[i] = false;
            }
        }
    }
}
