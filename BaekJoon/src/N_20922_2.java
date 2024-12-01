import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class N_20922_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int answer = 0;

        map.put(arr[right], 1);
        right += 1;

        while(left <= right && right < n){
            if(map.get(arr[right]) > k){
                map.put(arr[left], map.get(arr[left]) - 1);
                if(map.get(arr[left]) == 0) map.remove(arr[left]);
                left ++;
            }else {
                if(!map.containsKey(arr[right])){
                    map.put(arr[right], 1);
                }else map.put(arr[right], map.get(arr[right]) + 1);
                answer = Math.max(answer, right - left + 1);
                right ++;
            }

            System.out.println(map);
        }
        sb.append(answer).append("\n");
        System.out.println(sb);

    }
}
