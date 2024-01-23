import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_14888 {
    public static long max;
    public static long min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
        }

        st = new StringTokenizer(br.readLine());
        int[] opr = new int[4];
        for (int i = 0; i < 4; i++) {
            int num = Integer.parseInt(st.nextToken());
            opr[i] = num;
        }

        max = -1_000_000_000;
        min = 1_000_000_000;
        dfs(n, 1, nums[0], opr, nums);

        sb.append(max).append("\n");
        sb.append(min);
        System.out.println(sb);
    }

    public static void dfs(int n, int index, int now, int[] opr, int[] nums){
        if(index == n){
            max = Math.max(max, now);
            min = Math.min(min, now);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(opr[i] > 0){
                opr[i] --;
                if(i == 0){
                    dfs(n, index + 1, now + nums[index], opr, nums);
                }else if(i == 1){
                    dfs(n, index + 1, now - nums[index], opr, nums);
                }else if(i == 2){
                    dfs(n, index + 1, now * nums[index], opr, nums);
                }else if(i == 3){
                    dfs(n, index + 1, now / nums[index], opr, nums);
                }
                opr[i] ++;
            }
        }
    }
}
