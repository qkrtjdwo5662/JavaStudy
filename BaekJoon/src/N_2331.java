import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N_2331 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(a);

        while(true){
            int now = arrayList.get(arrayList.size()-1);

            int next = 0;
            while(now >= 1){
                int n = now % 10;

                next = next + (int)Math.pow(n, p);
                now = now /10;
            }

            if(arrayList.contains(next)) {
                System.out.println(arrayList.indexOf(next));
                return;
            }
            arrayList.add(next);
        }


    }

}
