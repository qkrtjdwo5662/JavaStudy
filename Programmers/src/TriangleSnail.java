import java.util.Arrays;

public class TriangleSnail {
    public static int n = 4;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(n)));
    }

    public static int[] solution(int n){
        int[][] snail = new int[n][n];

        int x = -1;
        int y = 0;
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x = x+1; // 세로
                } else if (i % 3 == 1) {
                    y = y+1; // 가로
                } else  {
                    x = x-1;
                    y = y-1;
                }

                snail[x][y] = num;
                num = num + 1;
            }
        }

        int len = n * (n+1) /2;
        int[] answer = new int[len];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index] = snail[i][j];
                index = index +1;
            }
        }
        return answer;
    }
}
