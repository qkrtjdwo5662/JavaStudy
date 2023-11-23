import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N_4195_2 {
    public static int[] parent;
    public static int[] c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 0; i <tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());// 친구 관계수

            HashMap<String, Integer> map = new HashMap<>();
            String[][] arr = new String[n][2];

            int num = 1;
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                String first = st.nextToken();
                String second = st.nextToken();

                arr[j][0] = first;
                arr[j][1] = second;

                if(!map.containsKey(first)){
                    map.put(first, num);
                    num++;
                }

                if(!map.containsKey(second)){
                    map.put(second, num);
                    num++;
                }
            }

            int size = map.size();
            parent = new int[size+1];
            c = new int[size+1];
            for (int j = 1; j <=size ; j++) {
                parent[j] = j;
                c[j] = 1;
            }


            for (int j = 0; j < n; j++) {
                String first = arr[j][0];
                String second = arr[j][1];

                int firstNum = map.get(first);
                int secondNum = map.get(second);


                sb.append(union(firstNum, secondNum)).append("\n");


            }
            
        }
        System.out.println(sb);
    }
    public static int union(int a, int b){
        int x = find(a);
        int y = find(b);

        if(x < y){
            c[y] += c[x];
            parent[x] = y;

            return c[y];
        }else if(x > y) {
            c[x] += c[y];
            parent[y] = x;

            return c[x];
        } else{
            return c[x];
        }

    }

    public static int find(int a){
        if(parent[a] == a){
            return a;
        }

        return parent[a] = find(parent[a]);
    }

}
