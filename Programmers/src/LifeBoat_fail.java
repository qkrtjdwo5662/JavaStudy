import java.util.Arrays;

public class LifeBoat_fail {
    public static int[] people = {70, 50, 80, 50};
    public static int limit = 100;
    public static void main(String[] args) {
        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit){
        int answer = 0;
        boolean[] visited = new boolean[people.length];

        Arrays.sort(people);

        for (int i = 0; i < people.length; i++) {
            if(!visited[i]){
                visited[i] = true; // 방문처리 하고
                int sum = 0;
                sum = sum + people[i];
                answer++;

                if(i == people.length-1) return answer;

                int index = i+1; // 다음 원소들 탐색
                while(index < people.length && sum + people[index] <= limit){
                    visited[index] = true;
                    sum = sum + people[index];
                    index++;
                }

            }
        }

        return answer;
    }
}
