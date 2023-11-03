import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class week_4_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

//        ArrayList<String> list = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        int answer = 0;

        // 집합 S의 원소
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            map.put(s, 0);
        }


        //집합 S에 원소인지
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if(map.containsKey(s)){
                answer++;
            }
        }

        System.out.println(answer);
    }
}
