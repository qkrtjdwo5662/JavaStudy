package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N_1974_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= tc ; i++) {
            int[][] board = new int[9][9];

            for (int j = 0; j < 9; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 9; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    board[j][k] = num;
                }
            }
            if(!verification3Times3(board) || !verification1Times9(board) || !verification9Times1(board)){
                sb.append("#").append(i).append(" ").append(0).append("\n");
            }else{
                sb.append("#").append(i).append(" ").append(1).append("\n");
            }

        }
        System.out.println(sb);


        // 1 X 9
        // 9 X 1
        // 3 X 3
    }

    public static boolean verification3Times3(int[][] board){
        // 0 ~ 2
        // 3 ~ 5
        // 6 ~ 8
        HashSet<Integer> set;
        for (int i = 0; i < 3; i++) {
            set = new HashSet<>();
            for (int j = 3*i; j < 3*i + 3; j++) {
                for (int k = 3*i; k < 3*i + 3; k++) {
                    int num = board[j][k];

                    if(num < 1 || 9 < num) return false;

                    if(set.contains(num)){
                        return false;
                    }else{
                        set.add(num);
                    }
                }
            }
        }

        return true;

    }

    public static boolean verification9Times1(int[][] board){
        HashSet<Integer> set;

        for (int i = 0; i < 9; i++) {
            set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                int num = board[i][j];

                if(num < 1 || 9 < num) return false;

                if(set.contains(num)){
                    return false;
                }else{
                    set.add(num);
                }
            }
        }

        return true;

    }

    public static boolean verification1Times9(int[][] board){
        HashSet<Integer> set;

        for (int i = 0; i < 9; i++) {
            set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                int num = board[j][i];

                if(num < 1 || 9 < num) return false;

                if(set.contains(num)){
                    return false;
                }else{
                    set.add(num);
                }
            }
        }

        return true;
    }
}
