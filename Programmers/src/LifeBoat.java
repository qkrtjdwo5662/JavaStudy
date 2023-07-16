import java.util.Arrays;

public class LifeBoat {
    public static int[] people = {10, 10, 20, 30};
    public static int limit = 100;

    public static void main(String[] args) {
        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit){
        int answer = 0;

        int minIndex = 0;
        int maxIndex = people.length-1;

        Arrays.sort(people);

        while(minIndex <= maxIndex){
            if(people[minIndex] + people[maxIndex] <= limit){
                answer++;
                minIndex++;
                maxIndex--;
            }else{
                answer++;
                maxIndex--;
            }
        }


        return answer;
    }
}
