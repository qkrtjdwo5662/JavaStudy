import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class N_17298_Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        Stack<Integer> stack = new Stack<>();
        int n =Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] result = new int[n];
        st= new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]){
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            result[stack.pop()]=-1;
        }
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}
