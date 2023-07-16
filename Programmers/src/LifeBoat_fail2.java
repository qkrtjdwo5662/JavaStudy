import java.util.Arrays;

public class LifeBoat_fail2 {
    public static int[] people = {10, 10, 20, 30};
    public static int limit = 100;

    public static void main(String[] args) {
        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit){
        int answer = 0;
        int sum = 0;
        int max = 0;

        Arrays.sort(people);

        boolean[] visited = new boolean[people.length];

        for (int i = 0; i < people.length; i++) {
            if(!visited[i]){
                sum = 0;
                visited[i] = true;
                sum = sum + people[i];
                answer++;
                for (int j = people.length-1; j >=0 ; j--) {
                    if(!visited[j] && max < sum + people[j] && sum+people[j]<=limit){
                        visited[j] = true;
                        sum = sum + people[j];
                    }
                }
            }
        }




        return answer;
    }
}
