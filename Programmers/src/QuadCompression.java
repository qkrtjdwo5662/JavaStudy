import java.util.Arrays;

public class QuadCompression {
    public static int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};

    public static int[] answer;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int[][] arr){
        answer = new int[2];
        int size = arr.length;
        divide(0, 0, size, arr);

        return answer;
    }

    public static void divide(int x, int y, int size, int[][] arr){
        if(checkColor(x, y, size, arr)){
            return;
        }

        divide(x, y, size/2, arr);
        divide(x + size/2, y, size/2, arr);
        divide(x, y + size/2, size/2, arr);
        divide(x + size/2, y + size/2, size/2, arr);

    }

    public static boolean checkColor(int x, int y, int size, int[][] arr){
        int color = arr[y][x];

        for (int i = y; i < y+size; i++) {
            for (int j = x; j < x+size; j++) {
                if(color != arr[i][j]) return false;
            }
        }

        answer[color] = answer[color] + 1;
        return true;
    }
}
