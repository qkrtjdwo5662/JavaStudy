import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_21941 {
    static class Ztring{
        String s;
        int point;

        public Ztring(String s, int point){
            this.s = s;
            this.point = point;
        }
    }

    static Ztring[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        arr = new Ztring[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String z = "";
            int point = 0;
            for (int j = 0; j < 2; j++) {
                if(j == 0) z = st.nextToken();
                else point = Math.max(Integer.parseInt(st.nextToken()), z.length());
            }

            arr[i] = new Ztring(z, point);
        }

        Arrays.sort(arr, (o1, o2) -> {
            return Integer.compare(o1.point, o2.point);
        });

        int answer = 0;
        for (int i = 0; i < n; i++) {
            Ztring now1 = arr[i];

            String s1 = now1.s;
            int point1 = now1.point;

            if(s.indexOf(s1) != -1){
                s = s.replaceFirst(s1, "");
                answer += point1;

                for (int j = 0; j < n; j++) {
                    Ztring now2 = arr[j];

                    String s2 = now2.s;
                    int point2 = now2.point;

                    if(s.indexOf(s2) != -1){
                        s = s.replaceFirst(s2, "");
                        answer += point2;
                        break;
                    }
                }
            }

        }

        answer += s.length();

        System.out.println(answer);
    }
}
