import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class N_1927_sort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(br.readLine());
            if(data == 0){
                if(arrayList.size() == 0){
                    sb.append(0).append("\n");
                    continue;
                }
                Collections.sort(arrayList); // 꺼내기 전에 정렬
                int poll = arrayList.get(0);
                arrayList.remove(0);
                sb.append(poll).append("\n");
            }else {
                arrayList.add(data);
            }
        }
        System.out.print(sb);
    }
}
