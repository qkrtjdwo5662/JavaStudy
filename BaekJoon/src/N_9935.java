import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_9935 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        String bomb = br.readLine();

        long beforeTime = System.currentTimeMillis();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        while(sb.indexOf(bomb)!=-1){
            sb.delete(sb.indexOf(bomb), sb.indexOf(bomb)+bomb.length());
            System.out.println(sb);
        }

        if(sb.length()!=0){
            System.out.println(sb);
        }else{
            System.out.println("FRULA");
        }
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        System.out.println(secDiffTime);
    }
}
