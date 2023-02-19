import java.util.Arrays;

public class BestFrequency {
    public static void main(String[] args) {
        int array[] = {1, 1, 2, 2};
        System.out.println(solution(array));
    }
    static int solution(int[] array) {
        int answer = 0;
        Arrays.sort(array);
        int max = 0;
        int check[] = new int[1000];
        for(int i=0; i<array.length; i++){
            check[array[i]] =  check[array[i]]+1;
        }
        for (int i = 0; i < check.length; i++) {
            if(max<check[i]){
                max = check[i];
                answer = i;
            } else if (max == check[i]) {
                answer = -1;
            }
        }
        return answer;
    }
}
