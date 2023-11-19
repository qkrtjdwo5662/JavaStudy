package D3;

import java.io.*;
import java.util.*;

public class N_6808{
    public static boolean[] visited;
    public static ArrayList<Integer> list;
    public static int[] gy;
    public static int[] iy;
    public static int win;
    public static int draw;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for(int i=1; i<= tc; i++) {
            st = new StringTokenizer(br.readLine());

            gy = new int[9]; // 규영 카드
            iy = new int[9]; // 인영 카드

            HashSet<Integer> set = new HashSet<>();
            ArrayList<Integer> list = new ArrayList<>();


            for(int j=0; j<9; j++) {

                int card = Integer.parseInt(st.nextToken());
                gy[j] = card;
                set.add(card);
            }

            for(int j=1; j<=18; j++) {
                if(!set.contains(j)) {
                    list.add(j);
                }
            }

            for(int j=0; j<9; j++) {
                iy[j] = list.get(j);
            }

            int max = 9*8*7*6*5*4*3*2*1;
            visited = new boolean[9];



            int answer = 0;
            win = 0;
            draw = 0;

            backtrack(0, 0, 0);
            int lose = max- win - draw;

            sb.append("#").append(i).append(" ").append(win).append(" ").append(lose).append("\n");
        }

        System.out.println(sb);
    }

    public static void backtrack(int count, int nowGY, int nowIY) {
        if(count == 9) { // 총점비교

            if(nowGY > nowIY) {
                win ++;
            }else if(nowGY== nowIY) {
                draw ++;
            }

            return;
        }

        for(int i=0; i<9; i++) { // 중복 없이 인영 카드 선
            if(!visited[i]) {
                visited[i] = true;

                int point = gy[count] + iy[i];
                if(compare(gy[count], iy[i])) {
                    // gy win
                    backtrack(count +1, nowGY + point, nowIY);
                }else {
                    // iy win
                    backtrack(count +1, nowGY, nowIY + point);
                }

                visited[i] = false;
            }
        }
    }

    public static boolean compare(int gy, int iy) {
        // answer == true : gy win
        // answer == false : iy win
//		System.out.println(gy + " " + iy);
        if(gy > iy) return true;
        else return false;


    }

}
