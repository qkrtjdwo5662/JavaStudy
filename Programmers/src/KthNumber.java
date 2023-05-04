import java.util.Arrays;

public class KthNumber{
    public static void main(String[] args){
        int array[] = {1,5,2,6,3,7,4};
        int commands[][] = {{2,5,3},{4,4,1},{1,7,3}};
        for(int i=0; i<solution(array, commands).length; i++){
            System.out.print(solution(array, commands)[i]);
        }

    }
    static public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] temp = array;
            temp=Arrays.copyOfRange(temp, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }
        return answer;
    }


}
