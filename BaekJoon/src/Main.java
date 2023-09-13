import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       int n = Integer.parseInt(st.nextToken());
       int h = Integer.parseInt(st.nextToken());
       int[] top = new int[h+1]; // 종유석
       int[] bottom = new int[h+1]; // 석순

       for (int i = 0; i <n/2 ; i++) {
           int top_data = Integer.parseInt(br.readLine());
           int bottom_data = Integer.parseInt(br.readLine());

           top[top_data]++;
           bottom[bottom_data]++;
       }
//        System.out.println(Arrays.toString(top));
//        System.out.println(Arrays.toString(bottom));

        for (int i = h-1; i >=1 ; i--) {
            top[i] = top[i] + top[i +1];
            bottom[i] = bottom[i] + bottom[i+1];
        } // 장애물에 걸린다는 보장이 되기때문에

//        System.out.println(Arrays.toString(top));
//        System.out.println(Arrays.toString(bottom));

        int[] arr = new int[h+1];

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= h ; i++) {
            arr[i]= bottom[i] + top[h-i+1];
            min = Math.min(arr[i], min);
        }

        int count = 0;
        for (int i = 1; i <= h ; i++) {
            if(arr[i] == min) count++;
        }
//        System.out.println(Arrays.toString(arr));

        System.out.println(min + " " + count);
    }
}