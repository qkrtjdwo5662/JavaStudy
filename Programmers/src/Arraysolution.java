import java.util.Arrays;

public class Arraysolution {
    static int array[];
    static int commands[][];
    public static void main(String[] args) {
        array = new int[]{1, 5, 2, 6, 3, 7, 4};
        commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        for (int i = 0; i < solution(array, commands).length; i++) {
            System.out.println(solution(array,commands)[i]+" ");
        }
    }
    static int[] solution(int[] array, int[][] commands){
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            int[] temp = new int[(commands[i][1] - commands[i][0])+1];
            for(int j=commands[i][0]-1; j<commands[i][1]; j++){
                temp[j-commands[i][0]-1] = array[j];
            }
            Arrays.sort(temp);
            answer[i] =temp[commands[i][2]-1] ;
        }

        return answer;
    }
}
