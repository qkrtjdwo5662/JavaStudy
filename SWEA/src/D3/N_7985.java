package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_7985 {
    public static int[] nodes;
    public static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            int n = (int)Math.pow(2, k);
            nodes = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n ; j++) {
                int num = Integer.parseInt(st.nextToken());

                nodes[j] = num;
            }

            tree = new int[n];
            recursion(1, n-1, 1);
            sb.append("#").append(i).append(" ");
            for (int j = 0; j < k; j++) {
                for (int l = (int)Math.pow(2, j); l <(int)Math.pow(2, j+1) ; l++) {
                    sb.append(tree[l]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void recursion(int left, int right, int index){
        int root = (left + right) /2;

        tree[index] = nodes[root];

        if(left == right){
            return;
        }

        recursion(left, root-1,index*2 );
        recursion(root + 1, right,index*2+1);


    }
}
