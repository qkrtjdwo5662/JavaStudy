import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1074_2 {
    public static int count = 0;
    public static int r;
    public static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);
        divide(0, 0, size);

    }

    public static void divide(int x, int y,int size){
        if(size == 2){ // size 2 될 때 까지 분할
            for (int i = y; i < y+size; i++) {
                for (int j = x; j < x+size; j++) {
                    if(i == r && j==c) {
                        System.out.println(count);
                        System.out.println("ttt");
                        return;
                    }
                    count++;
                    System.out.println(count);
                }
            }
            return;
        }

        if(y<=r && r < y + size/2 && x<=c && c < x + size/2){
            count = count;
            divide(x, y, size/2);
        }else if(y + size/2 <=r && r < y+size && x <=c && c < x+size/2){
            count= count + size/2 * size/2;
            divide(x+size/2, y, size/2);
        }else if(y<=r && r<y+size/2 && x+size/2<=c && c<x+size){
            count= count + size/2 * size/2 * 2;
            divide(x, y + size/2, size/2);
        } else if (y + size/2<=r && r<y+size && x+size/2 <= c && c<x+size) {
            count= count + size/2 * size/2 * 3;
            divide(x+size/2, y+size/2, size/2);
        }

    }
}
