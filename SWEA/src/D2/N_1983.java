package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1983 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 학생 수
            int k = Integer.parseInt(st.nextToken()); // 학점 알고 싶은 학생번호
            int [] student = new int[n+1];

            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());
                int total = 0;

                int middle = Integer.parseInt(st.nextToken());
                int finals = Integer.parseInt(st.nextToken());
                int assignment = Integer.parseInt(st.nextToken());

                total = (middle * 35 ) + (finals * 45) + (assignment *20 );
                student[j] = total;
            }
            sb.append("#").append(i).append(" ").append(grade(student, n, k)).append("\n");

        }
        System.out.println(sb);
    }

    public static String grade(int[] arr, int n, int k){
        int total = arr[k];
        int index = 0;
        Arrays.sort(arr);

        for (int i = n; i >0 ; i--) {
            if(arr[i] == total){
                index = i;
            }
        }
        String answer="";
        index = (index * 100) /n;

        if(index>90 ){
            answer = "A+";
        }else if(index > 80){
            answer = "A0";
        }else if(index > 70){
            answer = "A-";
        }else if(index > 60){
            answer = "B+";
        }else if(index > 50){
            answer = "B0";
        }else if(index > 40){
            answer = "B-";
        }else if(index > 30){
            answer = "C+";
        }else if(index > 20){
            answer = "C0";
        } else if (index > 10) {
            answer = "C-";
        }else{
            answer = "D0";
        }

        return answer;
    }
}
