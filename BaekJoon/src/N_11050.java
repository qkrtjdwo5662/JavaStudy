import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_11050 {
    static int [][] c = new int[11][11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        System.out.println(combination(n,r));
    }
    static int combination(int n, int r){
        if(c[n][r]>0){
            return c[n][r];
        }else if(n==r || r==0){
            return c[n][r]=1;
        }else{
            return c[n][r] = combination(n-1,r-1) + combination(n-1,r);
        }
    }
}
