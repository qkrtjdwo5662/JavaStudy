import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class N_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int n =Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st= new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n-2; i++){
            for (int j = i+1; j < n; j++) {
                if(arr[i]<arr[j]){
                    stack.push(arr[j]);
                }
            }
            if(stack.isEmpty()){
                System.out.print(-1+" ");
            }else {
                System.out.print(stack.firstElement()+" ");
                stack.clear();
            }
        }
        System.out.print(arr[n-1]+" "+-1);
    }
}
