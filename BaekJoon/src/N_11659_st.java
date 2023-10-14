import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_11659_st {
    public static int s_idx;
    public static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        s_idx = 1;
        while(s_idx < n){
            s_idx *= 2;
        }

        tree = new int[s_idx *2];
        s_idx --;


        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int data = Integer.parseInt(st.nextToken());
            update(i, data);
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(query(a, b)).append("\n");
        }

        System.out.println(sb);
    }
    public static int query(int left, int right){
        left = left + s_idx;
        right = right + s_idx;

        int sum = 0;
        while(left <= right){
            if(left %2 == 1){
                sum = sum + tree[left];
            }
            if(right % 2 == 0){
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

        while(idx >=1){
            tree[idx] = tree[idx*2] + tree[idx *2 + 1];
            idx = idx/2;
        }


    }

}