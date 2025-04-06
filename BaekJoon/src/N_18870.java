import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] arr2 = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            arr2[i] = num;
        }

        Arrays.sort(arr);

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < n; i++) {
            if(map.size() == 0){
                map.put(arr[i], index);
                index++;
            }else{
                if(!map.containsKey(arr[i])){
                    map.put(arr[i], index);
                    index ++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            sb.append(map.get(arr[i]));
        }

        System.out.println(sb);
    }
}
