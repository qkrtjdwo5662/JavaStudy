import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s;
        String[] array;
        String result="";
        for (int i = 0; i < n; i++) {
            s = br.readLine();
            array = s.split(" ");
            result="";
            for(int j=0; j < array.length; j++){
                for (int k = array[j].length()-1; k >=0 ; k--) {
                    result = result + array[j].charAt(k);
                }
                result=result+" ";
            }
            System.out.println(result);
        }

    }

}
