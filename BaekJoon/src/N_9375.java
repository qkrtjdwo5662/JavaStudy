import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class N_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            int answer = 1;
            HashMap<String,Integer> hashMap = new HashMap<>();
            for (int j = 0; j < n ; j++) {
                String s = br.readLine();
                if(hashMap.containsKey(s.split(" ")[1])){
                    hashMap.put(s.split(" ")[1],hashMap.get(s.split(" ")[1])+1);
                }else hashMap.put(s.split(" ")[1],1);
            }
            for(String key : hashMap.keySet()){
                answer = answer * (hashMap.get(key)+1);
            }
            sb.append(answer-1).append("\n");
        }
        System.out.print(sb);
    }
}
