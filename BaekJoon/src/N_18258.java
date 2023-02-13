import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            switch (a) {
                case "push":
                    int m = Integer.parseInt(st.nextToken());
                    queue.add(m);
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        bw.write(-1+"\n");
                    } else {
                        bw.write(queue.pollFirst()+"\n");
                    }
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        bw.write(1+"\n");
                    } else {
                        bw.write(0+"\n");
                    }
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        bw.write(-1+"\n");
                    } else {
                        bw.write(queue.getFirst()+"\n");
                    }
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        bw.write(-1+"\n");
                    } else {
                        bw.write(queue.getLast()+"\n");
                    }
                    break;
                case "size":
                    bw.write(queue.size()+"\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
