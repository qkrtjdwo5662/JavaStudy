public class Main{
    public static int[] arr = {1,2,3,4};
    public static boolean[] visited;
    public static void main(String[] args) {
        visited = new boolean[arr.length];
        backtrack("", 0);
    }
    public static void backtrack(String s, int num){
        if(s.length() == 4){
            System.out.println(s);
            return;
        }

        for (int i = num; i < arr.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                backtrack(s+arr[i], num+1);
                visited[i] = false;
            }

        }
    }
}