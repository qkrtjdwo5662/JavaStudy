import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s= br.readLine();
        String[] c = s.split(",");
        c[0] = c[0].replace("[","");
        c[c.length-1] = c[c.length-1].replace("]","");
//        for (int i = 0; i <s.length() ; i++) {
//            if(s.charAt(i)=='[' || s.charAt(i)==']' || s.charAt(i)==','){
//                continue;
//            }else System.out.println(s.charAt(i));
//        }
        System.out.println(Arrays.toString(c));
        for (int i = 0; i < c.length; i++) {
            System.out.print(Integer.parseInt(c[i])+" ");
        }
        System.out.println(c.length);


    }
}
