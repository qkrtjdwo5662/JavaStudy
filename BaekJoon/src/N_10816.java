import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_10816 {
    static int[] arr_n;
    static int[] arr_m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        arr_n = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr_n[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        Arrays.sort(arr_n);

        int m = Integer.parseInt(st.nextToken());
        arr_m = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr_m[i] = Integer.parseInt(st.nextToken());
            int key = arr_m[i];
            int low = 0;
            bw.write(upper(key,low, n)-lower(key,low, n)+" ");
        }
        bw.flush();
        bw.close();
    }
    static int lower(int key, int low, int high){
        while(low<high){
            int mid = (low + high)/2;
            if(key <= arr_n[mid]){
                high = mid;
            }else {
                low = mid +1;
            }
        }
        return high;
    }
    static int upper(int key, int low, int high){
        while(low<high){
            int mid = (low + high)/2;
            if(key < arr_n[mid]){
                high = mid;
            }else {
                low = mid +1;
            }
        }
        return high;
    }
//    static int solution(int key, int low, int high){
//        int answer = 0;
//        while(low<=high){
//            int mid = (low + high)/2;
//            if(key==arr_n[mid]){
//
//            }else if(key<arr_n[mid]){
//                high = mid-1;
//            }else low = mid+1;
//        }
//        return answer;
//    }

}
