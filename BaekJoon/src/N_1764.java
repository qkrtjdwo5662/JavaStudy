import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());



        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            hashMap.put(st.nextToken(), 0);
        }
        int count = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(hashMap.containsKey(s)){
                count ++;
                arrayList.add(s);
            }else continue;
        }

        Collections.sort(arrayList);

        sb.append(arrayList.size()).append("\n");
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i)).append("\n");
        }
        System.out.print(sb);
    }
}
