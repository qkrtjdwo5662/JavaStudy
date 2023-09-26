import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N_4195 {
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(st.nextToken());

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());

            HashMap<String, Integer> map = new HashMap<>();
            ArrayList<String[]> arrayList = new ArrayList<>();
            int index = 0;
            for (int j = 0; j < f; j++) {
                st = new StringTokenizer(br.readLine());
                String friend1 = st.nextToken();
                String friend2 = st.nextToken();

                if(!map.containsKey(friend1)){
                    map.put(friend1, index);
                    index++;
                }

                if(!map.containsKey(friend2)){
                    map.put(friend2, index);
                    index++;
                }

                arrayList.add(new String[]{friend1, friend2});
            }
            int n = map.size();
            parent = new int[n];

            for (int j = 0; j < n; j++) {
                parent[j] = j;
            }

            for (int j = 0; j < arrayList.size(); j++) {
                int a = map.get(arrayList.get(j)[0]);
                int b = map.get(arrayList.get(j)[1]);

                union(a, b);
                int count = 0;
                for (int k = 0; k < n; k++) {
                    if(find(a) == find(k)) count++;
                }
                sb.append(count).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        parent[x] = y;
    }
    public static int find(int a){
        if(parent[a] == a) return parent[a];
        return parent[a] = find(parent[a]);
    }
}
