import java.util.Arrays;

public class BestFrequency {
    public static void main(String[] args) {

    }
    static int solution(int[] array) {
        int answer = 0;
        Arrays.sort(array);
        int check = 1;
        for(int i=0; i<array.length; i++){
            if(array[i]==array[i+1]){
                check ++;

            }
        }
        return answer;
    }
}
