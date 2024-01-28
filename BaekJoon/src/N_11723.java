import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(st.nextToken());
        int set = 0;


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            String opr = st.nextToken();


            if(opr.equals("add")){
                // S에 num 추가
                int num = Integer.parseInt(st.nextToken());
                set = (set | (1 << (num - 1)));
            }else if(opr.equals("remove")){
                int num = Integer.parseInt(st.nextToken());
                if((set & (1 << (num - 1))) == (1 << (num - 1))){
                    set = (set ^ (1 << (num - 1)));
                }

            }else if(opr.equals("check")){
                int num = Integer.parseInt(st.nextToken());
                if( (set & (1 << (num - 1))) == (1 << (num - 1))){
                    sb.append(1).append("\n");
                }else sb.append(0).append("\n");
            }else if(opr.equals("toggle")){
                int num = Integer.parseInt(st.nextToken());
                if((set & (1 << (num - 1))) == (1 << (num - 1))){
                    set = (set ^ (1 << (num - 1)));
                }else set = (set | (1 << (num - 1) ));
            }else if(opr.equals("all")){
                set = (set | (1 << 20) - 1);
            }else if(opr.equals("empty")){
                set = 0;
            }
        }
        System.out.println(sb);
    }
}
