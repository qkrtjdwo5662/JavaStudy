import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class N_1463_2 {
    static class Info{
        int num;
        List<Integer> list;

        public Info(int num, List<Integer> list){
            this.num = num;
            this.list = list;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int x = Integer.parseInt(st.nextToken());

        // 1 -> 0
        // 2 -> 1
        // 3 -> 1
        // 4 -> 2
        // 5 -> 3
        //

        int[] arr = new int[1_000_000 + 1];

        for (int i = 2; i <= x ; i++) {
            arr[i] = arr[i - 1] + 1;
            if(i % 2 == 0){
                arr[i] = Math.min(arr[i / 2] + 1, arr[i]);
            }

            if(i % 3 == 0){
                arr[i] = Math.min(arr[i / 3] + 1, arr[i]);
            }
        }

        System.out.println(arr[x]);
    }
}
