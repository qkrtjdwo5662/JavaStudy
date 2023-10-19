package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N_1974 {
    public static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(st.nextToken());

        loop:
        for (int i = 1; i <= tc ; i++) {
            board = new int[9][9];

            for (int j = 0; j < 9; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 9; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    board[j][k] = num;
                }
            }
            int answer = 1;
            for (int j = 0; j <7 ; j+=3) {
                for (int k = 0; k <7 ; k+=3) {
                    if(!threeTimesThreeCheck(j, k)) {
                        sb.append("#").append(i).append(" ").append("0").append("\n");
                        continue loop;
                    }
                }
            }
            for (int j = 0; j < 9; j++) {
                if(!rowCheck(j)){
                    sb.append("#").append(i).append(" ").append("0").append("\n");
                    continue loop;
                }
            }

            for (int j = 0; j < 9; j++) {
                if(!colCheck(j)){
                    sb.append("#").append(i).append(" ").append("0").append("\n");
                    continue loop;
                }
            }


            sb.append("#").append(i).append(" ").append(answer).append("\n");


        }
        System.out.println(sb);
    }

    public static boolean threeTimesThreeCheck(int y, int x){
        boolean answer = true;
        HashSet<Integer> set = new HashSet<>();
        for (int i = y; i < y+3; i++) {
            for (int j = x; j < x+3; j++) {
                if(!set.contains(board[i][j])){
                    set.add(board[i][j]);
                }else return false;
            }
        }

        return answer;
    }

    public static boolean rowCheck(int index){
        boolean answer = true;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            if(!set.contains(board[index][i])){
                set.add(board[index][i]);
            }else return false;
        }
        return answer;
    }
    public static boolean colCheck(int index){
        boolean answer = true;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            if(!set.contains(board[i][index])){
                set.add(board[i][index]);
            }else return false;
        }
        return answer;
    }
}
