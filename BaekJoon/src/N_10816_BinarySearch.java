import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_10816_BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int []sgCard = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sgCard[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sgCard);

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(st.nextToken());
            sb.append(BinarySearch(sgCard, k)).append("\n");
        }
        System.out.println(sb);
    }
    public static int BinarySearch(int[] sgCard, int k){
        int left = 0;
        int right = sgCard.length-1;
        int count = 0;
        while(left<right){
            int middle = (left + right)/2;
            if(k<=middle){
                right = middle;
            }else left = middle+1;

        }
        if(sgCard[left]==k){
            return 1;
        }else return 0;
    }
}
