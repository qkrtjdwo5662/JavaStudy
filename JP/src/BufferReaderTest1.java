import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BufferReaderTest1 {
    public static void main(String[] args) throws IOException {
        System.out.println("이름, 도시, 나이, 체중, 독신여부 빈칸으로 분리하여 입력");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        String name = st.nextToken();
        System.out.println("이름은" + name);
        String city = st.nextToken();
        System.out.println("도시는"+ city);
        int age = Integer.parseInt(st.nextToken());
        System.out.println("나이는" + age);
        int weight = Integer.parseInt(st.nextToken());
        System.out.println("몸무게는" + weight);
        boolean isSingle = Boolean.parseBoolean(st.nextToken());
        System.out.print("독신여부는 "+ isSingle);



    }
}
