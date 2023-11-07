import java.util.Arrays;

public class KthNumber_2 {
    public static int[] array = {1, 5, 2, 6, 3, 7, 4};
    public static int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(array, commands)));
    }

    public static int[] solution(int[] array, int[][] commands){
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] temp = new int[commands[i][1] - commands[i][0] + 1];

            for (int j = 0; j < temp.length; j++) {
                temp[j] = array[j+commands[i][0]-1];
            }

            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}
