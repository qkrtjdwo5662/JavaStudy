import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2579_3 {
    public static int answer =0;
    public static int[] arr;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());

            arr[i] = num;
        }
        answer = 0;
        dfs(arr[0], 0, 0, "");
        System.out.println(answer);
    }

    public static void dfs(int now, int index, int count, String s){
        if(index == n){
            System.out.println(s);
            answer = Math.max(answer, now);
            return;
        }

        if(index + 1 <= n){
            if(count < 2){
                dfs(now + arr[index+1], index + 1, count +1, s+" " +  arr[index+1]);
            }
        }

        if(index + 2 <= n){
            dfs(now + arr[index+2], index + 2, 1, s+" " +  arr[index+2]);
        }


    }
}
