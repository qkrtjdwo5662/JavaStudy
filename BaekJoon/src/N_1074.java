import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1074 {
    public static int count = 0;
    public static int r;
    public static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2,n);

        divide(0, 0, size);
    }
    public static void divide(int startX, int startY, int size){
        if(size == 2){
            for (int i = startY; i < startY + size; i++) {
                for (int j = startX; j < startX + size; j++) {
                    if(i==r && j==c) {
                        System.out.print(count);
                        System.exit(0);
                    }
                    count = count +1;
                }
            }
            return;
        }

        if(startX <= c && c<startX+size/2 && startY<=r && r<startY+size/2){
            count = count;
            divide(startX, startY, size/2);

        }else if(startX + size/2 <= c && c<startX+size && startY<=r && r<startY+size/2){
            count = count + size/2 * size/2;
            divide(startX + size/2, startY, size/2);
        }else if(startX  <= c && c<startX+size/2 && startY + size/2 <=r && r<startY+size){
            count = count + size/2 * size/2 * 2;
            divide(startX, startY + size/2, size/2);

        }else if(startX + size/2 <= c && c<startX+size && startY + size/2 <=r && r<startY+size){
            count = count + size/2 * size/2 * 3;
            divide(startX + size/2, startY + size/2, size/2);

        }





    }
}
