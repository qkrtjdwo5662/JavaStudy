import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class N_11478_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

//        HashSet<String> set = new HashSet<>();
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                String str = s.substring(j, j+i+1);
                if(!arrayList.contains(str)){
                    arrayList.add(str);
                }
            }
        }
        System.out.println(arrayList.size());

    }
}
