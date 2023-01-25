import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class permutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        boolean visited[] = new boolean[n];

        perm(arr, visited, 0, n, r);
    }
    static void perm(int[] arr, boolean[] visited, int depth, int n, int r){
        if(depth==r){
            for (int i = 0; i < r; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i+1;
                perm(arr,visited, depth+1, n, r);
                visited[i]=false;
            }
        }
    }
}
