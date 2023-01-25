import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_10974 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        boolean[] visited  = new boolean[n];

        perm(arr,visited,n,0);

    }
    static void perm(int[] arr, boolean[] visited, int n, int depth){
        //깊이 탐색으로 depth가 n이 된다면
        //모든 arr 출력
        if(depth==n){
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        //depth가 n이 될때까지 반복한다.
            //visited[i]가 false면
            //arr[depth] <-
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                arr[depth] = i+1;
                visited[i] = true;
                perm(arr, visited, n, depth+1);
                visited[i] = false;
            }
        }
    }
}
