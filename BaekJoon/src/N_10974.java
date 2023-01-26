import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_10974{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        boolean visited[] = new boolean[n];
        permutation(arr, visited, 0, n, n);
    }
    static void permutation(int[] arr, boolean[] visited, int depth, int n, int r){
        if(depth==r){
            for (int i = 0; i <n ; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i+1;
                permutation(arr, visited, depth+1, n, r );
                visited[i] = false;
            }
        }
    }
}