package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

//        int tc = Integer.parseInt(st.nextToken());

        int[][] board = new int[4][4];

        int n = board.length * board[0].length;
        int index = 1;
        while(index < board.length){
            for (int i = index; i >0 ; i--) {
                System.out.print(i + " " + (index- i+1)+ " ") ;
            }
            System.out.println();
            index += 1;
        }

//        for (int i = 1; i <= tc ; i++) {
//            int answer = 0;
//
//            sb.append("#").append(i).append(" ").append(answer).append("\n");
//        }

        System.out.println(sb);
    }
}
