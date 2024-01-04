import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N_3584 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] parents = new int[n+1];

            for (int j = 0; j < n-1; j++) {
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                parents[child] = parent;
            }
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            HashSet<Integer> parentList = new HashSet<>();
            int answer = findParent(parentList, v1, v2, parents);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static int findParent(HashSet<Integer> parentList, int v1, int v2, int[] parents){
        while(v1 != 0){
            parentList.add(v1);
            v1 = parents[v1];
        }

        while(v2 != 0){
            if(parentList.contains(v2)){
                return v2;
            }
            parentList.add(v2);
            v2 = parents[v2];
        }

        return 0;
    }
}
