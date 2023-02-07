import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push":
                    int k = Integer.parseInt(st.nextToken());
                    queue.addLast(k);
                    break;
                case "pop":
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(queue.pollFirst());
                    }
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if(queue.isEmpty()){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                    break;
                case "front":
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(queue.getFirst());
                    }
                    break;
                case "back":
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(queue.getLast());
                    }
            }
        }
    }
}
