package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_7985 {
    public static int s_idx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            s_idx = 0;
            int k = Integer.parseInt(st.nextToken());

            int[] tree = new int[(int)Math.pow(2, k)];
            s_idx = (int)Math.pow(2, k-1);
            int index = 1;

            st = new StringTokenizer(br.readLine());
            while(index < tree.length){
                int num = Integer.parseInt(st.nextToken());

                tree[s_idx] = num;

                if(s_idx/2 != 1 && s_idx%2 == 0){ // 루트 노드 자식이 아니고, s_idx가 짝수라면
                    s_idx = s_idx+1;
                }else if(s_idx/2 != 1 && s_idx%2 == 1){ // 루트 노드 자식이 아니고, s_idx가 홀수라면
                    s_idx = s_idx/2;
                }

                if(s_idx == 1){
                    s_idx = s_idx*2 + 1;
                }

                index++;
            }
            sb.append("#").append(i).append(" ");

        }
    }
}
