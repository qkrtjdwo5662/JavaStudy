import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N_1043 {
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 사람 수
        int m = Integer.parseInt(st.nextToken()); // 파티 수

        parent = new int[n+1];
        int answer =0;
        for (int i = 1; i <= n ; i++) {
            parent[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        int knowNum = Integer.parseInt(st.nextToken()); // 알고있는 사람 수

        int[] know = new int[knowNum]; // 알고있는 사람 배열
        for (int i = 0; i < knowNum; i++) {
            int num = Integer.parseInt(st.nextToken());
            know[i] = num;
        }

        for (int i = 0; i < knowNum; i++) { // 아는 사람 하나로 묶어버리기
            int a = know[i];

            union(a);
        }


        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int people = Integer.parseInt(st.nextToken()); // 파티참여 사람 수
            int[] party = new int[people]; // 파티 참여 배열

            for (int j = 0; j < people ; j++) {
                int num = Integer.parseInt(st.nextToken());
                party[j] = num;
            }

            if(check(party)) {
                answer++;
            }else{
                for (int j = 0; j < people ; j++) {
                    int a = party[j];

                    union(a);
                }
            }



        }
        System.out.println(answer);

    }

    public static boolean check(int[] arr){
        System.out.println(Arrays.toString(arr));

        HashSet<Integer> set = new HashSet<>();
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            set.add(parent[arr[i]]);
        }

        if(set.size() != n) return false;
        else return true;
    }

    public static void union(int a){
        int x = find(a);

        parent[x] = 0;
    }

    public static int find(int a){
        if(parent[a] == a){
            return parent[a];
        }

        return parent[a] = find(parent[a]);
    }
}
