import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_1874{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int n = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int k=1;
        stack.addLast(k);
        k++;
        for (int i = 0; i < n; i++) {
            if(arr[0]==1){
                System.out.println("NO");
                return;
            }
            else{
                if(arr[i]!=k) {
                    if(stack.getLast()==k){
                        stack.pollLast();
                        System.out.println("-");
                        k++;
                    }else{
                        for (int j = k; j < arr[i]; j++) {
                            stack.addLast(k);
                            System.out.println("+");
                        }
                    }

                }else{
                    stack.addLast(k);
                    System.out.println("+");
                    stack.pollLast();
                    System.out.println("-");
                    k++;
                }
            }
        }

    }
}