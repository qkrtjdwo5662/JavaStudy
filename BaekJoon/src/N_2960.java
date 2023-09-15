import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n+1];

        int min = 2;
        int count = 0;
        int answer = 0;
        while(min<=n){
            if(!visited[min]){
                visited[min] = true;
                count++;
                if(count == k) {
                    answer = min;
                    break;
                }
                for (int i = min; i <= n; i= i+min) {
                    if(!visited[i]){
                        visited[i] = true;
                        count++;

                        if(count == k) {
                            answer = i;
                            break;
                        }
                    }
                }

            }else{
                min++;
            }
        }
        System.out.println(answer);

    }
}
