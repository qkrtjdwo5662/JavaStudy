import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1275 {
    public static int s_idx;
    public static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        s_idx = 1;
        while(s_idx < n){
            s_idx *= 2;
        }

        tree = new long[s_idx*2];
        s_idx--;
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n ; i++) {
            int num = Integer.parseInt(st.nextToken());
            update(i, num);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(x > y){
                sb.append(query(y, x)).append("\n");
            }else{
                sb.append(query(x, y)).append("\n");
            }

            update(a, b);
        }
        System.out.println(sb);
    }
    public static long query(int left, int right){
        left = left + s_idx;
        right = right + s_idx;

        long sum = 0;
        while(left <= right){
            if(left %2 == 1){
                sum = sum + tree[left];
            }

            if(right %2 == 0){
                sum = sum + tree[right];
            }

            left = (left + 1) /2;
            right = (right -1) /2;
        }


        return sum;
    }
    public static void update(int idx, int num){
        idx = idx + s_idx;
        tree[idx] = num;
        idx = idx/2;

        while(idx >= 1){
            tree[idx] = tree[idx *2] + tree[idx *2 + 1];
            idx = idx/2;
        }
    }
}
