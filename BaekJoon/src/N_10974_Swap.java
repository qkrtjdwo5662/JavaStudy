import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_10974_Swap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = {1,2,3};

        permutation(arr, 0, n, n);
    }
    static void permutation(int[] arr, int depth, int n, int r){
        if(depth==r){
            for (int i = 0; i < r; i++) {
                System.out.print(arr[i]+ " ");
            }
            System.out.println();
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth+1, n, r);
            swap(arr, depth, i);
        }
    }
    static void swap(int[] arr, int depth, int i){
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
