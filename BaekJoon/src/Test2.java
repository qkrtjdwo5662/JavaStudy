import java.util.Arrays;
import java.util.StringTokenizer;

public class Test2 {
    public static void main(String[] args) {
        String s = "1+2+3-4-5+6+23+29-20";


        System.out.println(Arrays.toString(s.split("[+|-]")));

        StringTokenizer st = new StringTokenizer(s, "+|-");

        System.out.println();
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }

        System.out.println();
        st = new StringTokenizer(s, "+|-", true);
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
}
