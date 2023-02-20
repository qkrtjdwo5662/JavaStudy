import java.io.*;
import java.util.StringTokenizer;

public class N_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int answer =0;
        int score = 1;
        for (int i = 0; i < n; i++) {
            answer = 0;
            score = 1;
            StringTokenizer st= new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < s.length()-1; j++) {
                if(s.charAt(j)=='O'){
                    answer = answer +score;
                    if(s.charAt(j+1)=='O'){
                        score++;
                    }else{
                        score = 1;
                    }
                }else continue;
            }
            if(s.charAt(s.length()-1)=='O'){
                answer = answer +score;
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();

    }
}
