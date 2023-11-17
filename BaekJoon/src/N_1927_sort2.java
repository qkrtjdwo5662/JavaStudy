import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class N_1927_sort2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                if(list.size() == 0){
                    sb.append(0).append("\n");
                }else{
                    Collections.sort(list);
                    sb.append(list.get(0)).append("\n");
                    list.remove(0);
                }
                continue;
            }

            list.add(num);
        }
        System.out.println(sb);


    }
}
