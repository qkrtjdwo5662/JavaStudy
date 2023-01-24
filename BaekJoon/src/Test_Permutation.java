import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test_Permutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        boolean[] visited = new boolean[n];

        perm(arr, visited, 0, n);
    }
   static void perm(int[] arr, boolean[] visited, int depth, int n){
        if(depth ==n){
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i= 0; i<n; i++){
            if(visited[i])
                continue;
            arr[depth] = i+1;
            visited[i] = true;
            perm(arr,visited,depth+1, n);
            visited[i] = false;
        }
    }
}
