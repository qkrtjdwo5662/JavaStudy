import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class SegmentTree {
    public static int n = 10;
    public static int s_idx;
    public static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s_idx = 1;
        while(s_idx < n){
            s_idx *= 2;
        }

        System.out.println(s_idx);

        tree = new long[s_idx *2];
        s_idx--;
        for (int i = 1; i <= n ; i++) {
            long num = Long.parseLong(br.readLine());
            update(i, num);
        }
        System.out.println(Arrays.toString(tree));
    }

    public static void update(int idx, long num){
        idx = idx + s_idx;
        tree[idx] = num;
        idx = idx/2;

        while(idx >= 1){
            tree[idx] = tree[idx*2] + tree[idx*2 + 1];
            idx = idx / 2;
        }
    }
}
