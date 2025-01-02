import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1244_2 {
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n  ; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            go(gender, num);
        }

        for (int i = 1; i <= n ; i++) {
            sb.append(arr[i]).append(" ");
            if(i % 20 == 0) sb.append("\n");
        }
        System.out.println(sb);


    }
    static void go(int gender, int num){
        if(gender == 1){ // m
            int index = num;
            while(index <= n){
                if(arr[index] == 0){
                    arr[index] = 1;
                }else arr[index] = 0;

                index += num;
            }

        }else if(gender == 2){ // w
            int index = 0;
            while(num - index > 0 && num + index <= n){
                if(arr[num + index] == arr[num - index]){
                    if(arr[num + index] == 1){
                        arr[num + index] = 0;
                        arr[num - index] = 0;
                    }else{
                        arr[num + index] = 1;
                        arr[num - index] = 1;
                    }

                    index ++;
                }else break;
            }

        }
    }
}
