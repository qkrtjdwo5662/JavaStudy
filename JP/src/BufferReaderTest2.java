import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BufferReaderTest2 {
    public static void main(String[] args) throws IOException {
        System.out.println("점수 입력");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int score = Integer.parseInt(st.nextToken());

        if(score>80){
            System.out.println("합격");
        }else{
            System.out.println("불합격");
        }


    }
}
