import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class perm_swap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] arr = {1,2,3};
        perm(arr, 0, n, r);

    }
    static void perm(int[] arr, int depth, int n, int r){
        if(depth==r){
            for (int i = 0; i < r; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr,depth, i);
            perm(arr, depth+1, n, r);
            swap(arr, depth, i);
        }
    }
    static void swap(int[] arr, int depth, int i){
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
