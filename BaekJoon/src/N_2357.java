import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2357 {
    public static int s_idx;
    public static int[] max_tree;
    public static int[] min_tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        s_idx = 1;
        while(s_idx < n){
            s_idx = s_idx * 2;
        }

        max_tree = new int[s_idx * 2];
        min_tree = new int[s_idx * 2];
        s_idx --;


        for (int i = 1; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            int data = Integer.parseInt(st.nextToken());
            max_update(i, data);
            min_update(i, data);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(min_query(a, b)).append(" ").append(max_query(a, b)).append("\n");
        }
        System.out.print(sb);


    }
    public static int max_query(int left, int right){
        left = left + s_idx;
        right = right + s_idx;

        int max = 0;

        while(left <= right){
            if(left % 2 == 1){
                max = Math.max(max, max_tree[left]);
            }

            if(right % 2 == 0){
                max = Math.max(max, max_tree[right]);
            }

            left = (left + 1) / 2;
            right = (right -1) / 2;
        }

        return max;
    }

    public static int min_query(int left, int right){
        left = left + s_idx;
        right = right + s_idx;

        int min = Integer.MAX_VALUE;

        while(left <= right){
            if(left % 2 == 1){
                min = Math.min(min, min_tree[left]);
            }

            if(right % 2 == 0){
                min = Math.min(min, min_tree[right]);
            }

            left = (left + 1) / 2;
            right = (right -1) / 2;
        }

        return min;
    }


    public static void max_update(int idx, int num){
        idx = idx + s_idx;
        max_tree[idx] = num;
        idx = idx/2;

        while(idx >= 1){
            max_tree[idx] = Math.max(max_tree[idx *2], max_tree[idx * 2 + 1]);
            idx = idx / 2;
        }
    }

    public static void min_update(int idx, int num){
        idx = idx + s_idx;
        min_tree[idx] = num;
        idx = idx/2;

        while(idx >= 1){
            min_tree[idx] = Math.min(min_tree[idx *2], min_tree[idx * 2 + 1]);
            idx = idx / 2;
        }
    }
}
