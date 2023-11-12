import java.util.Scanner;

class Solution {
    public static int[] arr = {1,2,3,4};
    public static boolean[] visited;
    public static void main(String[] args) throws Exception {
        visited = new boolean[arr.length];
        dfs("");
    }

    public static void dfs(String s){
        if(s.length() == arr.length){
            System.out.println(s);
        }

        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(s+arr[i]);
                visited[i] = false;
            }
        }
    }
}