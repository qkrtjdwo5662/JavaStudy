import java.util.Arrays;

public class KthNumber {
    public static void main(String[] args) {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};

        for (int i = 0; i < solution(array,commands).length; i++) {
            System.out.print(solution(array,commands)[i]+" ");
        }
    }
    static int[] solution(int[] array, int[][] commands){
        int[] result = new int[commands.length];
        int[] temp;
        for (int i = 0; i < commands.length ; i++) {
            temp =Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
            Arrays.sort(temp);
            result[i] = temp[commands[i][2]-1];
        }

        return result;
    }
}
