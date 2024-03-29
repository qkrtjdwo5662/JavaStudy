import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_1043 {
    public static int[] parent;
    public static boolean[] know;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 사람 수 
        int m = Integer.parseInt(st.nextToken()); //  파티 수 

        parent = new int[n+1];
        know = new boolean[n+1]; // 알고있는 사람
        for(int i=1; i<= n; i++){
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken()); // 진실 아는 사람 수

        for (int i = 0; i <tc ; i++) {
            int num = Integer.parseInt(st.nextToken());

            know[num] = true;

            // 진실을 알고있으면 true
        }


        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int party = Integer.parseInt(st.nextToken()); // 파티 참가 인원

            ArrayList<Integer> list = new ArrayList<>();

            for (int j = 0; j < party; j++) {
                int num = Integer.parseInt(st.nextToken());

                list.add(num);
            }

            for (int j = 0; j < party-1; j++) {
                int now = list.get(j);
                int next = list.get(j+1);

                union(now, next);
            }

            arrayList.add(list);
        }

        for (int i = 1; i <= n; i++) {
            if(know[i]){
                know[find(i)] = true;
            }
        }

        int answer = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            ArrayList<Integer> list = arrayList.get(i);

            boolean check = false;
            for (int j = 0; j < list.size(); j++) {
                int num = list.get(j);

                if(know[find(num)]){
                    check = true;
                    break;
                }
            }

            if(!check) answer ++;

        }

        System.out.println(answer);
    }

    public static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        parent[x] = y;
    }
    public static int find(int a){
        if(parent[a] == a){
            return parent[a];
        }
        return parent[a] = find(parent[a]);
    }
}
