import java.util.Arrays;

public class LifeBoat_3 {
    public static int[] people = {70, 50, 80};
    public static int limit = 100;

    public static void main(String[] args) {
        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit){
        int answer = 0;

        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;

        while(left <= right){
            if(people[left] + people[right] <= limit){
                left++;
            }
            right --;
            answer++;
        }
        return answer;
    }
}
