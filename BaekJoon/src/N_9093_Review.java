import java.io.*;

public class N_9093_Review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] arr = s.split(" ");
            String result="";
            for (int j =0; j <arr.length; j++) {
                for (int k = arr[j].length()-1; k >= 0; k--) {
                    result =result + arr[j].charAt(k);
                }
                result = result+" ";
            }
            bw.write(result+"\n");
        }
        bw.flush();
        bw.close();
    }
}
