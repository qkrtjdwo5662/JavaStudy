import java.util.Arrays;
import java.util.PriorityQueue;

public class DiskController {
    public static int[][] jobs = {{0,3},{1,9},{2,6}};
    public static void main(String[] args) {
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs){
        int answer = 0;

        Arrays.sort(jobs, (o1,o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        for (int i = 0; i < jobs.length; i++) {
            pq.add(new int[]{jobs[i][0], jobs[i][1]});
        }

        int[] first = pq.poll(); // 0 , 3
        int startFirst = first[0]; // 시작 0
        int timeFirst = first[1]; // 3

        answer = timeFirst; // 처음 작업 걸린 시간
        startFirst = startFirst + timeFirst;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int start = now[0];
            int time = now[1];

            answer = answer + startFirst - start + time;
            startFirst = startFirst + time;
        }


        answer = answer/ jobs.length;

        return answer;
    }
}
